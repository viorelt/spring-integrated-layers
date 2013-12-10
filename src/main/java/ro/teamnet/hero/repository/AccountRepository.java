package ro.teamnet.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.teamnet.hero.domain.Account;

import java.math.BigDecimal;

/**
 * AccountRepository.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,BigDecimal>{
}
