package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Account;
import com.example.demo.model.AccountOpeningDetails;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public long addAccount(AccountOpeningDetails accountDetails)
	{
		//call to customer profile service
		//setting the common fields of both table
		Customer customer=new Customer();
		customer.setAccountNo(accountDetails.getAccountNo());
		customer.setCustomerName(accountDetails.getAccountName());
		customer.setCustomerId(accountDetails.getCustomerId());
		customer.setMailId(accountDetails.getMailId());
		customer.setPhoneNo(accountDetails.getPhoneNo());
		final String uri = "http://localhost:8091/bank/customers/add";
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);
	    ResponseEntity<Customer> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Customer.class);
		//saving account data to repository
	    Account account=new Account();
	    account.setAccountNo(accountDetails.getAccountNo());
	    account.setAccountName(accountDetails.getAccountName());
	    account.setAccountType(accountDetails.getAccountType());
	    account.setAccountBalance(accountDetails.getAccountBalance());
		Account accounts=accountRepository.save(account);
		if(accounts!=null)
		{
			return accounts.getAccountNo();
		}
		return 0;
	}
	
	//displaying account
	public ArrayList<Account> viewAllAccount()
	{
		ArrayList<Account> accountList= (ArrayList<Account>) accountRepository.findAll();
		if(accountList != null)
			{
				return accountList;
			}
		return null;
		
	}

	public Account viewAccountById(long accountId) 
	{
		Optional<Account> accountIdPresent=accountRepository.findById(accountId);
		if(accountIdPresent.isPresent())
		{
			return accountIdPresent.get();
		}
		return null;
	}

	public Account updateAccount(Account account) 
	{
		Account accounts=accountRepository.save(account);
		if(accounts!=null)
		{
			return accounts;
		}
		
		return null;
	}

	public boolean deleteAccountById(long accountId)
	{
		boolean checkAccountExist=accountRepository.existsById(accountId);
		if(checkAccountExist)
		{
			accountRepository.deleteById(accountId);
			
			return true;
		}
			
		
		
		return false;
	}

	public ArrayList<Account> viewAccountsByType(String accountType) {
		
		ArrayList<Account> accountTypeList=accountRepository.viewAccountByType(accountType);
		
		if(accountTypeList!=null)
		{
			return accountTypeList;
		}
		
		return null;
	}

	public ArrayList<Account> viewAccountsByName(String accountName) {
		ArrayList<Account> accountNameList=accountRepository.viewAccountByName(accountName);
		if(accountNameList != null)
		{
			return accountNameList;
		}
		return null;
	}

	public Double getAccountBalanceByIdAndType(long accountId, String accountType) {
		
		Optional<Account> account=accountRepository.findById(accountId);
		if(account.isPresent())
		{
			if(accountRepository.viewAccountByType(accountType)!=null)
			{
				Double bal=accountRepository.getAccountBalanceByIdAndType(accountId,accountType);
				return bal;
			}
			
		}
		return null;
	}
	 /*@Transactional
	public Boolean updateAccountBalance(long accountId, String transType, double amt) {
		if(transType.equals("Debit"))
		{
			Optional id=accountRepository.findById(accountId);
			if(id != null)
			{
				Double bal=accountRepository.getAccountBalanceById(accountId);
				double updatedBal=bal-amt;
				accountRepository.updateBalance(accountId,updatedBal);
				return true;
			}
			return false;
			
		}
		else if(transType.equals("Credit"))
		{
			Optional id=accountRepository.findById(accountId);
			if(id != null)
			{
				Double bal=accountRepository.getAccountBalanceById(accountId);
				double updatedBal=bal+amt;
				accountRepository.updateBalance(accountId,updatedBal);
				return true;
			}
			return false;
		}
		return false;
	}*/
	
	
	
}
