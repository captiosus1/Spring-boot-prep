package com.indraneela.spring_boot_tutorial.Repository;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.Prefix;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){
        Transaction transaction = Transaction.builder()  // Use lowercase 'id' as conventionally properties are named in camelCase
                .date(new Date(2024 - 1900, 10, 4)) // Adjust for the year and month
                .amount(580)
                .catergoryID(2) // Fixed spelling of 'category'
                .merchantAccount("SampleMerchant 2")
                .comments("Nothing") // Corrected typo from "Nothings"
                .build();

        testEntityManager.persist(transaction);
    }

    @Test
    public void byIDtes(){
        Transaction transaction = transactionRepository.findById(1).get();
        assertEquals(transaction.getCatergoryID(), 2);
    }

}