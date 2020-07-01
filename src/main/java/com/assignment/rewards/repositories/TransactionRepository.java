package com.assignment.rewards.repositories;

import com.assignment.rewards.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByTransactionDateBetween(
            LocalDate transactionTimeStart,
            LocalDate transactionTimeEnd);
}
