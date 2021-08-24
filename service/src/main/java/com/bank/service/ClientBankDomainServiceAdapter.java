package com.bank.service;

import com.bank.api.ClientBankDomain;

/**
 * THIS IS EXPECTED TO BECOME A SPRING-BOOT SERVICE
 */

public class ClientBankDomainServiceAdapter implements ClientBankDomain {
    @Override
    public Double checkBalanceAccount(final String code) {
        return null;
    }

    @Override
    public double depositAccount(final Double amount, final String code) {
        return 0;
    }

    @Override
    public Double withdrawlAccount(final Double amount, final String code) {
        return null;
    }

    // Check the class diagram

}
