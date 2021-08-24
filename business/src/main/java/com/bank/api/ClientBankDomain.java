package com.bank.api;

/**
 * This interface should define the behavior of the service
 */
public interface ClientBankDomain {

    //Check account
    Double checkBalanceAccount(String code) throws Exception;

    //DEPOSIT
    double depositAccount(Double amount, String code) throws Exception;

    //WITHDRAWAL
    Double withdrawlAccount(Double amount, String code) throws Exception;
}
