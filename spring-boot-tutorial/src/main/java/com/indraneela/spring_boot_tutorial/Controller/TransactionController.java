package com.indraneela.spring_boot_tutorial.Controller;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import com.indraneela.spring_boot_tutorial.Service.TransactionService;
import com.indraneela.spring_boot_tutorial.errors.TransactionNotFound;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    @PostMapping("/transactions")
    public Transaction saveTransaction(@Valid @RequestBody Transaction transaction){
        LOGGER.info("EXECUTED - saveTransaction from TransactionController");
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/transactionHistory")
    public List<Transaction> getTransactions() throws TransactionNotFound {
        LOGGER.info("EXECUTED - getTransactions from TransactionController");
        List<Transaction> transactions = transactionService.getTransactions();
        if(transactions.isEmpty())
            throw new TransactionNotFound("Transactions are empty");
        return transactions;
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionbyID(@PathVariable("id") Integer ID) throws TransactionNotFound{
        return transactionService.getTransactionbyID(ID);
    }

    @DeleteMapping("/transaction/{id}")
    public String deleteTransactionbyID(@PathVariable("id") Integer ID){

        return transactionService.getdeleted(ID);
    }

    @PutMapping("/transaction/{id}")
    public Transaction updateTransactionbyID(@PathVariable("id") Integer ID,@Valid @RequestBody Transaction transaction){
        return transactionService.updateTransactionbyID(ID, transaction);
    }

    @GetMapping("/transaction/merchant/{upi}")
    public Transaction getTransactionbyID(@PathVariable("upi") String merchantID){
        return transactionService.getTransactionbyUPI(merchantID);
    }
}
