package com.bank.pnc.account.pncbank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.pnc.account.pncbank.entity.AccountTransactionEntity;

@Repository
public interface AccountTransactionRepo extends CrudRepository<AccountTransactionEntity, Long>{
	
	@Query(value = "select a from AccountTransactionEntity a where a.accountNumber = :accountNumber and a.transactionType = :transactionType")
	List<AccountTransactionEntity> findByAccountNumberAndTransactionType(@Param("accountNumber") Integer accountNumber, 
																		@Param("transactionType") String transactionType);

	
	@Query(value = "select a from AccountTransactionEntity a where a.accountNumber = :accountNumber and a.createdDate BETWEEN :startDate AND :endDate")
	List<AccountTransactionEntity> findByAccountNumberAndCreatedDate(@Param("accountNumber") Integer accountNumber, 
																		@Param("startDate") Date startDate,
																		@Param("endDate") Date endDate);

	List<AccountTransactionEntity> findByAccountNumber(Integer accountNumber, Pageable pageable);
}
