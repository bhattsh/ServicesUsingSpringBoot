package com.capgemini.bankWebApp.transactionService.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankWebApp.transactionService.entity.Transaction;
import com.capgemini.bankWebApp.transactionService.entity.TransactionType;
import com.capgemini.bankWebApp.transactionService.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Override
	public Double deposit(Integer accountNumber, Double currentBalance, Double amount) {
		
		Transaction transaction = new Transaction();
		
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		currentBalance += amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactionDetails("paytm");
		transaction.setTransactionType(TransactionType.DEPOSIT);
		repository.save(transaction);
		return currentBalance;
	}

}
