package com.indraneela.spring_boot_tutorial.Service;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import com.indraneela.spring_boot_tutorial.errors.TransactionNotFound;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getTransactions();

    Transaction getTransactionbyID(int id) throws TransactionNotFound;

    String getdeleted(Integer id);

    Transaction updateTransactionbyID(Integer id, Transaction transaction);

    Transaction getTransactionbyUPI(String merchantID);
}
