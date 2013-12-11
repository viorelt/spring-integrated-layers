package ro.teamnet.hero.service;

import ro.teamnet.hero.domain.Account;

import java.math.BigDecimal;
import java.util.List;

/**
 * AccountService.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */

public interface AccountService {

    Account createAccount(Account account);

    Account findById(BigDecimal idAccount);

    List<Account> findAll();
}
