package com.indraneela.spring_boot_tutorial.Service;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import com.indraneela.spring_boot_tutorial.Repository.TransactionRepository;
import com.indraneela.spring_boot_tutorial.errors.TransactionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.getallTransactions();
    }

    @Override
    public Transaction getTransactionbyID(int id) throws TransactionNotFound {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(!transaction.isPresent())
            throw new TransactionNotFound("Transaction not found");
        return transaction.get();
    }

    @Override
    public String getdeleted(Integer id) {
        transactionRepository.deleteById(id);
        return "Succesfully Deleted ID = "+id;
    }

    @Override
    public Transaction updateTransactionbyID(Integer id, Transaction transaction) {
        Transaction temptrans = transactionRepository.findById(id).get();
        if(Objects.nonNull(transaction.getMerchantAccount())&&!"".equalsIgnoreCase(transaction.getMerchantAccount())){
            temptrans.setMerchantAccount(transaction.getMerchantAccount());
        }

        if(transaction.getAmount()!=0)
            temptrans.setAmount(transaction.getAmount());

        if(transaction.getCatergoryID()!=0)
            temptrans.setCatergoryID(transaction.getCatergoryID());

        if(Objects.nonNull(transaction.getDate()))
            temptrans.setDate(transaction.getDate());

        if(Objects.nonNull(transaction.getComments())&&!"".equalsIgnoreCase(transaction.getComments())){
            temptrans.setComments(transaction.getComments());
        }
        return transactionRepository.save(temptrans);
    }

    @Override
    public Transaction getTransactionbyUPI(String merchantID) {
        return transactionRepository.findByMerchantAccountIgnoreCase(merchantID);
    }
}
