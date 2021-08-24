package com.bank.domain;

import com.bank.api.ClientBankDomain;
import com.bank.model.Account;
import com.bank.spi.AccountRepository;
import com.bank.spi.ClientRepository;

import java.util.Optional;
import java.util.logging.Logger;

/*
 * THIS IS NOT EXPECTED TO BECOME A SPRING-BOOT SERVICE
 */
public class ClientBankDomainImpl implements ClientBankDomain {

    private static final Logger logger = Logger.getLogger(ClientBankDomainImpl.class.getName());
    public static final String CAN_T_FIND_ACCOUNT = "Can't find account.";

    private AccountRepository accountRepository; // call this to read and save accounts but no need to implement how for the moment
    private ClientRepository clientRepository;  // call this to read and save clients but no need to implement how for the moment

    // DEFINE METHODS HERE. PAY ATTENTION TO INTERFACE

    public Double checkBalanceAccount(final String code) throws Exception {
        Optional <Account> account = accountRepository.findByCode(code);
        if (account.isPresent()){
            return account.get().getBalance();
        }
        else{
            logger.warning(CAN_T_FIND_ACCOUNT);
            throw new Exception(CAN_T_FIND_ACCOUNT);
        }
    }

    @Override
    public double depositAccount (final Double amount, final String code) throws Exception {
        Optional <Account> account = accountRepository.findByCode(code);
        if (account.isPresent()){
            account.get().setBalance(account.get().getBalance() + amount);
            accountRepository.update(account.get());
            return account.get().getBalance();
        }
        else{
            logger.warning(CAN_T_FIND_ACCOUNT);
            throw new Exception(CAN_T_FIND_ACCOUNT);
        }
    }

    @Override
    public Double withdrawlAccount (final Double amount, final String code) throws Exception {
        Optional <Account> account = accountRepository.findByCode(code);
        if (account.isPresent()){
            account.get().setBalance(account.get().getBalance() - amount);
            accountRepository.update(account.get());
            return account.get().getBalance();
        }
        else{
            logger.warning(CAN_T_FIND_ACCOUNT);
            throw new Exception(CAN_T_FIND_ACCOUNT);
        }
    }

}