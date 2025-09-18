package com.example.banking;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
            new SavingsAccount("SAV001","Ravi",20000),
            new CurrentAccount("CUR001","Maya",50000)
        );

        for (BankAccount a : accounts) {
            System.out.println(a.getHolderName() + " (" + a.getAccountNumber() + ") -> Balance: " + a.getBalance() + ", Interest: " + a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable) a;
                System.out.println("Loan Eligibility: " + l.calculateLoanEligibility());
            }
            System.out.println("-----");
        }
    }
}

