package ro.teamnet.hero.controller;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public ResponseEntity<String> accountList(){

        List<Account> accountList=accountService.findAll();
        JSONSerializer jsonSerializer=new JSONSerializer();
        String accountListJson=jsonSerializer
                .exclude("*.class")
                .exclude("person")
                .serialize(accountList);
        return new ResponseEntity<String>(accountListJson, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createAccount(@RequestBody String json){
        Account accountTransient=new JSONDeserializer<Account>()
                .use(null, Account.class)
                .deserialize(json);
        Account accountDetached=accountService.createAccount(accountTransient);
        return new ResponseEntity<String>(new JSONSerializer()
                .exclude("*.class")
                .exclude("person")
                .serialize(accountDetached),HttpStatus.OK);
    }
}
