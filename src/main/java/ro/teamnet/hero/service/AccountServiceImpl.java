package ro.teamnet.hero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.hero.domain.Account;
import ro.teamnet.hero.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * AccountServiceImpl.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(BigDecimal idAccount) {
        return accountRepository.findOne(idAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
