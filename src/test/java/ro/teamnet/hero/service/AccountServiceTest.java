package ro.teamnet.hero.service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.teamnet.hero.config.InfrastructureConfig;
import ro.teamnet.hero.domain.Account;
import ro.teamnet.hero.domain.Person;

import java.math.BigDecimal;

/**
 * AccountServiceTest.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={InfrastructureConfig.class})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    private Account account;
    @Before
    public void setUp() throws Exception {
        account=new Account();
        account.setUserName("myFirstJpaTest");
        account.setEmail("test@hero.ro");
        account.setPassword("secret");
        Person person=new Person();
        person.setFirstName("First Test");
        person.setLastName("Last Name");
        account.setPerson(person);
    }

    @Test
    public void testCreateAccount() throws Exception {
        Account testAccount=accountService.createAccount(account);
        Assert.assertNotNull(testAccount.getId());
    }

    @Test
    public void testFindById() throws Exception {
        Account account1=accountService.findById(BigDecimal.ONE);
        Assert.assertNotNull(account1);
            Account account2=accountService.findById(BigDecimal.valueOf(2));
        Assert.assertNotNull(account2);

    }
}
