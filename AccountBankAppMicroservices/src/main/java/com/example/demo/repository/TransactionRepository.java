/*
 * package com.example.demo.repository;
 * 
 * import org.springframework.data.jpa.repository.Modifying; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.CrudRepository; import
 * org.springframework.data.repository.query.Param;
 * 
 * import com.example.demo.model.AccountOpeningDetails;
 * 
 * public interface TransactionRepository extends
 * CrudRepository<AccountOpeningDetails, Long>{
 * 
 * @Query(value="SELECT b.Accountbalance FROM Bankaccountss b WHERE " +
 * "b.Accountno LIKE CONCAT('%',:accountId, '%') ",nativeQuery=true) Double
 * getAccountBalanceById(@Param("accountId") long accountId);
 * 
 * @Modifying
 * 
 * @Query(
 * value="UPDATE Bankaccountss b SET b.Accountbalance = :updatedBal WHERE " +
 * "b.Accountno = :accountId",nativeQuery=true) int
 * updateBalance(@Param("accountId") long accountId,@Param("updatedBal") double
 * updatedBal);
 * 
 * }
 */