package com.capgemini.bankWebApp.transactionService.service;

public interface TransactionService {

	Double deposit(Integer accountNumber, Double currentBalance, Double amount);

}
