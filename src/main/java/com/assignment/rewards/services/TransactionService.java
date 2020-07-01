package com.assignment.rewards.services;

import com.assignment.rewards.domain.Transaction;
import com.assignment.rewards.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }


}
