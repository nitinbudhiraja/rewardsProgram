package com.assignment.rewards.controller;

import com.assignment.rewards.domain.Transaction;
import com.assignment.rewards.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        Transaction txn = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(txn,HttpStatus.OK);
    }
}
