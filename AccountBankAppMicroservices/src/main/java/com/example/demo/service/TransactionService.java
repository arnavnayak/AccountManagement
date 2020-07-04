/*
 * package com.example.demo.service;
 * 
 * import java.util.ArrayList; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * //import com.example.demo.model.Account; import
 * com.example.demo.model.AccountOpeningDetails; import
 * com.example.demo.repository.TransactionRepository;
 * 
 * 
 * 
 * @Service public class TransactionService {
 * 
 * @Autowired TransactionRepository transactionRepository; //display public
 * ArrayList<AccountOpeningDetails> viewAllAccount() {
 * ArrayList<AccountOpeningDetails> accountList=
 * (ArrayList<AccountOpeningDetails>) transactionRepository.findAll();
 * if(accountList != null) { return accountList; } return null;
 * 
 * }
 * 
 * 
 * //balance public Double getAccountBalanceById(long accountId) {
 * 
 * Optional<AccountOpeningDetails>
 * transaction=transactionRepository.findById(accountId);
 * if(transaction.isPresent()) {
 * 
 * Double bal=transactionRepository.getAccountBalanceById(accountId); return
 * bal;
 * 
 * } return null; }
 * 
 * //debit
 * 
 * @Transactional public Boolean debitFromAccount(long accountId,double amt) {
 * 
 * Optional id=transactionRepository.findById(accountId); if(id != null) {
 * Double bal=transactionRepository.getAccountBalanceById(accountId); double
 * updatedBal=bal-amt;
 * transactionRepository.updateBalance(accountId,updatedBal); return true; }
 * return false;
 * 
 * 
 * }
 * 
 * //credit
 * 
 * @Transactional public Boolean creditToAccount(long accountId, double amt) {
 * Optional id=transactionRepository.findById(accountId); if(id != null) {
 * Double bal=transactionRepository.getAccountBalanceById(accountId); double
 * updatedBal=bal+amt;
 * transactionRepository.updateBalance(accountId,updatedBal); return true; }
 * return false; }
 * 
 * //account to account
 * 
 * @Transactional public Boolean accountToAccount(long sourceId, long destId,
 * double amt) {
 * 
 * 
 * if(debitFromAccount(sourceId,amt)) { if(creditToAccount(destId,amt)) { return
 * true; } }
 * 
 * return false; }
 * 
 * 
 * 
 * }
 */