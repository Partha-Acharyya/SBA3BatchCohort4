package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.CreditCard;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.RecurringDeposit;

@Repository
public interface UserRepository extends JpaRepository<Account, Long>{
	List<Account> findByCustomerId(Long customerId);

	
}
