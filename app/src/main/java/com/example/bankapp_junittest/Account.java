package com.example.bankapp_junittest;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException();
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        balance -= amount;
    }
}


