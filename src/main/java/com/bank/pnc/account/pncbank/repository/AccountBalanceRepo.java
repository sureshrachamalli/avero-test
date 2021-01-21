package com.bank.pnc.account.pncbank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.pnc.account.pncbank.entity.AccountEntity;

@Repository
public interface AccountBalanceRepo extends CrudRepository<AccountEntity, Long>{

	List<AccountEntity> findByAccountNumber(Integer accountNumber);
}
