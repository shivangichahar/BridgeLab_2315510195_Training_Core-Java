package com.example.banking;

public interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

