package ro.teamnet.hero.controller;

import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.teamnet.hero.domain.Account;
import ro.teamnet.hero.service.AccountService;

import java.util.List;

/**
 * AccountController.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> accountList(){

        List<Account> accountList=accountService.findAll();
        JSONSerializer jsonSerializer=new JSONSerializer();
        String accountListJson=jsonSerializer
                .exclude(".class")
                .serialize(accountList);
        return new ResponseEntity<String>(accountListJson, HttpStatus.OK);
    }
}
