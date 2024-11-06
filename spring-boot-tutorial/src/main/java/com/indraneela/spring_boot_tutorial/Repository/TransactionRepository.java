package com.indraneela.spring_boot_tutorial.Repository;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
        public Transaction findByMerchantAccount(String UPI);

        public Transaction findByMerchantAccountIgnoreCase(String UPI);

    @Query(value = "select * from transaction",nativeQuery = true)
    public List<Transaction> getallTransactions();
}
