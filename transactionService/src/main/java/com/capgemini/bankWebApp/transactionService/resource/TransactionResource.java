package com.capgemini.bankWebApp.transactionService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bankWebApp.transactionService.entity.Transaction;
import com.capgemini.bankWebApp.transactionService.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<Transaction> deposit(@RequestParam Transaction transaction) {
		
		System.out.println("hello trans");
		ResponseEntity<Double> entity = restTemplate.getForEntity("http://localhost:9090/accounts/"+transaction.getAccountNumber()+"/balance",Double.class);
		Double currentBalance = entity.getBody();
		
		Double updateBalance = transactionService.deposit(transaction.getAccountNumber(), currentBalance, transaction.getAmount());
		
		restTemplate.put("http://localhost:9090/accounts/"+transaction.getAccountNumber()+"?currentBalance="+updateBalance, null);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
}
