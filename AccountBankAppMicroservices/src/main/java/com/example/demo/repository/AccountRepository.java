package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Account;
import com.example.demo.model.AccountOpeningDetails;

public interface AccountRepository extends CrudRepository<Account,Long>{
	
	 @Query(value = "SELECT * FROM Bankaccountss b WHERE " +
	            "LOWER(b.Accounttype) LIKE LOWER(CONCAT('%',:accountType, '%'))",nativeQuery=true)
	 ArrayList<Account> viewAccountByType(@Param("accountType") String accountType);

	 @Query(value="SELECT * FROM Bankaccountss b WHERE LOWER(b.Accountname) LIKE LOWER(CONCAT('%',:accountName,'%'))",nativeQuery=true)
	ArrayList<Account> viewAccountByName(@Param("accountName") String accountName);

	 @Query(value="SELECT b.Accountbalance FROM Bankaccountss b WHERE " +
	            "b.Accountno LIKE CONCAT('%',:accountId, '%') AND " +
	            "LOWER(b.Accounttype) LIKE LOWER(CONCAT('%',:accountType, '%'))",nativeQuery=true)
	Double getAccountBalanceByIdAndType(@Param("accountId") long accountId,@Param("accountType") String accountType);

	 @Query(value="SELECT b.Accountbalance FROM Bankaccountss b WHERE " +
	            "b.Accountno LIKE CONCAT('%',:accountId, '%') ",nativeQuery=true)
	Double getAccountBalanceById(@Param("accountId") long accountId);

	 /*@Modifying
	 @Query(value="UPDATE Bankaccounts b SET b.Accountbalance = :updatedBal WHERE " +
	            "b.Accountno = :accountId",nativeQuery=true)
	int updateBalance(@Param("accountId") long accountId,@Param("updatedBal") double updatedBal);*/

	 
}
