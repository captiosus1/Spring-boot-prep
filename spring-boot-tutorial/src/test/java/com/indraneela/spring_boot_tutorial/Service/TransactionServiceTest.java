package com.indraneela.spring_boot_tutorial.Service;

import com.indraneela.spring_boot_tutorial.Entity.Transaction;
import com.indraneela.spring_boot_tutorial.Repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @MockBean
    TransactionRepository transactionRepository;
    @BeforeEach
    void setUp() {
        Transaction transaction = Transaction.builder() // Use lowercase 'id' as conventionally properties are named in camelCase
                .date(new Date(2024 - 1900, 10, 4)) // Adjust for the year and month
                .amount(580)
                .catergoryID(2) // Fixed spelling of 'category'
                .merchantAccount("SampleMerchant 2")
                .comments("Nothing") // Corrected typo from "Nothings"
                .build();

        Mockito.when(transactionRepository.findByMerchantAccountIgnoreCase("SampleMerchant 2")).thenReturn(transaction);
    }

    @Test
    public void whenValidMerchanName_thenTransactionFound(){
        String merchchantID = "SampleMerchant 2";
        Transaction transFound = transactionService.getTransactionbyUPI(merchchantID);
        assertEquals(merchchantID,transFound.getMerchantAccount());
    }
}