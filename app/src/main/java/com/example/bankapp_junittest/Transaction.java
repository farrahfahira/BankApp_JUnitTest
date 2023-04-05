package com.example.bankapp_junittest;

import java.time.LocalDateTime;

public class Transaction {
    private final LocalDateTime timestamp;
    private final double amount;
    private final double balance;
    private final TransactionType type;

    public Transaction(LocalDateTime timestamp, double amount, double balance, TransactionType type) {
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}


