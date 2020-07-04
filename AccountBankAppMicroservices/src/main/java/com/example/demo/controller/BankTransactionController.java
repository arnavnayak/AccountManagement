/*
 * package com.example.demo.controller;
 * 
 * import java.util.ArrayList;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * //import com.example.demo.model.Account; import
 * com.example.demo.model.AccountOpeningDetails; import
 * com.example.demo.service.TransactionService;
 * 
 * @RestController
 * 
 * @RequestMapping("/bank") public class BankTransactionController {
 * 
 * @Autowired TransactionService transactionService;
 * 
 * //display all
 * 
 * @RequestMapping(value="/accounts",method=RequestMethod.GET)
 * ResponseEntity<ArrayList<AccountOpeningDetails>> viewAllAccount() { return
 * new ResponseEntity<ArrayList<AccountOpeningDetails>>(transactionService.
 * viewAllAccount(),HttpStatus.OK);
 * 
 * }
 * 
 * //balance check
 * 
 * @RequestMapping(value="/accounts/bal",method=RequestMethod.GET)
 * ResponseEntity<Double> getAccountBalanceById(@RequestParam("id") long
 * accountId) { return new
 * ResponseEntity<Double>(transactionService.getAccountBalanceById(accountId),
 * HttpStatus.OK);
 * 
 * }
 * 
 * //debit from account
 * 
 * @RequestMapping(value="/trans/debit",method=RequestMethod.PUT)
 * ResponseEntity<Boolean> debitFromAccount(@RequestParam("id") long
 * accountId,@RequestParam("val") double amt) { return new
 * ResponseEntity<Boolean>(transactionService.debitFromAccount(accountId,amt),
 * HttpStatus.CREATED);
 * 
 * } //credit to account
 * 
 * @RequestMapping(value="/trans/credit",method=RequestMethod.PUT)
 * ResponseEntity<Boolean> creditToAccount(@RequestParam("id") long
 * accountId,@RequestParam("val") double amt) { return new
 * ResponseEntity<Boolean>(transactionService.creditToAccount(accountId,amt),
 * HttpStatus.CREATED);
 * 
 * } //account to account transaction
 * 
 * @RequestMapping(value="/trans/acctoacc",method=RequestMethod.PUT)
 * ResponseEntity<Boolean> accountToAccount(@RequestParam("fromAccntId") long
 * sourceId,@RequestParam("toAccntId") long destId,@RequestParam("val") double
 * amt) {
 * 
 * return new
 * ResponseEntity<Boolean>(transactionService.accountToAccount(sourceId,destId,
 * amt),HttpStatus.OK);
 * 
 * 
 * } }
 */