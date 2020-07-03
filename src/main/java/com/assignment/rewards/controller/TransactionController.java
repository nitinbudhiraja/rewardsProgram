package com.assignment.rewards.controller;

import com.assignment.rewards.domain.Transaction;
import com.assignment.rewards.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Value("${transaction.add.success}")
    private String SUCCESS;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addTransaction(@ModelAttribute("transaction") Transaction transaction){
        Transaction txn = transactionService.addTransaction(transaction);
        ModelAndView mav = new ModelAndView();
        mav.addObject("transaction", new Transaction());
        mav.addObject("message", SUCCESS);
        mav.setViewName("add-transaction");
        return mav;
    }
}
