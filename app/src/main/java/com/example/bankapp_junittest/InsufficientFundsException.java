package com.example.bankapp_junittest;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds in account");
    }
}
