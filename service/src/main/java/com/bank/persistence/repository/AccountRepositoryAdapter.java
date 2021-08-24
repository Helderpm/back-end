package com.bank.persistence.repository;

import com.bank.model.Account;
import com.bank.persistence.entity.AccountEntity;
import com.bank.spi.AccountRepository;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * THIS IS EXPECTED TO BECOME A SPRING-BOOT REPOSITORY
 */

public class AccountRepositoryAdapter implements AccountRepository {

    private static final Logger logger = Logger.getLogger(AccountRepositoryAdapter.class.getName());
    public static final String CAN_T_FIND_ACCOUNT = "Can't find account.";
    private AccountJPARepository accountJPARepository;

    @Override
    public Optional<Account> findByCode(final String code) {
        Long idAccount = accountJPARepository.findIdByCode(code);
        if (idAccount != null){
            AccountEntity accountEntity = accountJPARepository.getOne(idAccount);
            Account account = new Account(accountEntity.getCode());
            account.setBalance(accountEntity.getBalance());
            return Optional.of(account);
        }
        return Optional.empty();
    }

    @Override
    public void save(final Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCode(account.getCode());
        accountEntity.setBalance(account.getBalance());
        accountJPARepository.save(accountEntity);
    }

    @Override
    public void update(final Account account) throws Exception {
        Long idAccount = accountJPARepository.findIdByCode(account.getCode());
        if (idAccount != null){
            accountJPARepository.deleteById(idAccount);
            save(account);
        }
        else{
            logger.warning(CAN_T_FIND_ACCOUNT);
            throw new Exception(CAN_T_FIND_ACCOUNT);
        }
    }
}
