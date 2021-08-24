package com.bank.spi;

import com.bank.model.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findByCode(String code) throws Exception;

    void update(Account account) throws Exception;

    void save(Account account);
}
