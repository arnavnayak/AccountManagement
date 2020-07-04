package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.AccountOpeningDetails;
import com.example.demo.model.Customer;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/bank/accounts")
public class BankAccountController {

	@Autowired
	AccountService accountService;
	
	//add account
	@RequestMapping(value="/account",method=RequestMethod.POST)
	ResponseEntity<Long> addBankAccount(@RequestBody AccountOpeningDetails account)
	{ 
		return new ResponseEntity<Long>(accountService.addAccount(account),HttpStatus.CREATED);
		
	}
	
	//display all
	@RequestMapping(value="/view",method=RequestMethod.GET)
	ResponseEntity<ArrayList<Account>> viewAllAccount()
	{
		return new ResponseEntity<ArrayList<Account>>(accountService.viewAllAccount(),HttpStatus.OK);
		
	}
	//display by id
	@RequestMapping(value="/account",method=RequestMethod.GET)
	ResponseEntity<Account> viewAccountById(@RequestParam("id") long accountId)
	{
		return new ResponseEntity<Account>(accountService.viewAccountById(accountId),HttpStatus.OK);
		
	}
	//display by account type
	@RequestMapping(value="/account/type",method=RequestMethod.GET)
	ResponseEntity<ArrayList<Account>> viewAccountsByType(@RequestParam("accountType") String accountType)
	{
		
		return new ResponseEntity<ArrayList<Account>>(accountService.viewAccountsByType(accountType),HttpStatus.OK); 
	}
	//display account by name
	@RequestMapping(value="/account/name",method=RequestMethod.GET)
	ResponseEntity<ArrayList<Account>> viewAccountsByName(@RequestParam("accountName") String accountName)
	{
		return new ResponseEntity<ArrayList<Account>>(accountService.viewAccountsByName(accountName),HttpStatus.OK);
	}
	//update values
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	ResponseEntity<Account> updateAccount(@RequestBody Account account)
	{
		return new ResponseEntity<Account>(accountService.updateAccount(account),HttpStatus.OK);
		
	}
	
	//delete account by id
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	ResponseEntity<Boolean> deleteAccountById(@PathVariable("id") long accountId)
	{
		return new ResponseEntity<Boolean>(accountService.deleteAccountById(accountId),HttpStatus.OK);
	}
	
	//display balance according to id and type
	@RequestMapping(value="/balance",method=RequestMethod.GET)
	ResponseEntity<Double> getAccountBalanceById(@RequestParam("id") long accountId,@RequestParam("accountType") String accountType)
	{
		return new ResponseEntity<Double>(accountService.getAccountBalanceByIdAndType(accountId,accountType),HttpStatus.OK);
		
	}
	
	
	
	
}
