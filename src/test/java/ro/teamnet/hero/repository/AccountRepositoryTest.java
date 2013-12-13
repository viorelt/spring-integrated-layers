package ro.teamnet.hero.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import ro.teamnet.hero.config.InfrastructureConfig;

/**
 * AccountRepositoryTest.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfig.class})

public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testFindByUserName() throws Exception {
        Assert.notNull(accountRepository.findByUserName("hero"));
    }
}
