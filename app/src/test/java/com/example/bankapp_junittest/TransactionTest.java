package com.example.bankapp_junittest;


import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

    private LocalDateTime timestamp;
    private double amount;
    private double balance;
    private TransactionType type;
    private Transaction transaction;

    @Before
    public void setUp() {
        timestamp = LocalDateTime.of(2023, 4, 5, 12, 30, 0);
        amount = 1000.0;
        balance = 5000.0;
        type = TransactionType.WITHDRAWAL;
        transaction = new Transaction(timestamp, amount, balance, type);
    }

    /*memastikan bahwa implementasi metode getTimestamp() berfungsi
    dengan benar dan menghasilkan nilai yang sesuai dengan yang diharapkan*/
    @Test
    public void testGetTimestamp() {
        assertEquals(timestamp, transaction.getTimestamp());
    }

    /*Test ini bertujuan untuk memastikan bahwa
    method getAmount() pada class Transaction dapat mengembalikan
    nilai yang sesuai dengan nilai yang telah di-set sebelumnya pada constructor*/
    @Test
    public void testGetAmount() {
        assertEquals(amount, transaction.getAmount(), 0.0);
    }

    /*Test ini bertujuan untuk
    memastikan bahwa method getType() pada class Transaction
    mengembalikan nilai yang benar.*/
    @Test
    public void testGetType() {
        assertEquals(type, transaction.getType());
    }
}
