package com.example.bankapp_junittest;


import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {


    /* Test bahwa  method getBalance() akan mengembalikan nilai sama dengan
    nilai saldo awal yg diberikan pada parameter ketika akun baru dibuat */
    @Test
    public void testGetBalance_returnsInitialBalance() {
        Account account = new Account(100);
        assertEquals(100, account.getBalance(), 0.0);
    }

    /*Test bahwa nilai getBalance() berubah setelah melakukan deposit*/
    @Test
    public void testGetBalance_returnsUpdatedBalanceAfterDeposit() {
        double initialBalance = 100.0;
        double depositAmount = 50.0;
        Account account = new Account(initialBalance);
        account.deposit(depositAmount);
        assertEquals(initialBalance + depositAmount, account.getBalance(), 0.0);
    }

    /*Test bahwa nilai getBalance() berubah setelah melakukan withdraw*/
    @Test
    public void testGetBalance_returnsUpdatedBalanceAfterWithdraw() throws InsufficientFundsException {
        double initialBalance = 100.0;
        double withdrawAmount = 50.0;
        Account account = new Account(initialBalance);
        account.withdraw(withdrawAmount);
        assertEquals(initialBalance - withdrawAmount, account.getBalance(), 0.0);
    }

    /*Test bahwa nilai getBalance() tidak berubah
    setelah melakukan withdraw dengan jumlah yang melebihi saldo akun*/
    @Test
    public void testGetBalance_doesNotChangeAfterWithdrawWithInsufficientFunds() {
        double initialBalance = 100.0;
        double withdrawAmount = 150.0;
        Account account = new Account(initialBalance);
        try {
            account.withdraw(withdrawAmount);
        } catch (InsufficientFundsException e) {
            // Do nothing
        }
        assertEquals(initialBalance, account.getBalance(), 0.0);
    }

    /* Test yang menjalankan fungsi deposit akan menambah nilai saldo akun*/
    @Test
    public void deposit() {
        Account account = new Account(300);
        account.deposit(100.0);
        assertEquals(400.0, account.getBalance(), 0.0);
    }

    /* Test yang menjalankan fungsi withdraw akan mengurangi nilai saldo akun*/
    @Test
    public void withdraw() throws InsufficientFundsException {
        Account account = new Account(300);
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(350.0, account.getBalance(), 0.0);
    }

    /* Test bahwa method withdraw tidak bisa menarik saldo apabila
    uang pada akunnya tidak cukup */
    @Test
    public void testWithdrawInsufficientFunds() {
        Account account = new Account(1000);
        double amount = 1500;

        try {
            account.withdraw(amount);
            fail("Expected InsufficientFundsException was not thrown");
        } catch (InsufficientFundsException e) {
            assertEquals("InsufficientFundsException message", "Insufficient funds in account", e.getMessage());
            assertEquals("Account balance", 1000, account.getBalance(), 0);
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getMessage());
        }
    }

    /* Test method withdraw akan mengembalikan exception
    apabila menarik bilangan negatif */
    @Test(expected = IllegalArgumentException.class)
    public void withdrawWithNegativeAmount() throws InsufficientFundsException {
        Account account = new Account(100.00);
        account.withdraw(-50.00);
    }
}