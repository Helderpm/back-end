package com.bank.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/clients/steve.jobs") //...for user: 'steve.jobs'(always)
public class ClientBankDomainServiceRest {

    private final ClientBankDomainServiceAdapter clientBankDomainServiceAdapter;

    public ClientBankDomainServiceRest(final ClientBankDomainServiceAdapter clientBankDomainServiceAdapter) {
        this.clientBankDomainServiceAdapter = clientBankDomainServiceAdapter;
    }

    // get balance of account
    @GetMapping("/acconts/{code}")
    public Double getBalanceAccount( @PathVariable String code) {
        return clientBankDomainServiceAdapter.checkBalanceAccount(code);
    }

    // get balance of account
    @GetMapping("/acconts/{code}/Deposit/{amount}")
    public Double getDepositAccount(@PathVariable Double amount, @PathVariable String code) {
        return clientBankDomainServiceAdapter.depositAccount(amount, code);
    }

    // get balance of account
    @GetMapping("/acconts/{code}/withdrawl/{amount}")
    public Double getWithdrawlAccount(@PathVariable Double amount, @PathVariable String code) {
        return clientBankDomainServiceAdapter.withdrawlAccount(amount, code);
    }

}
