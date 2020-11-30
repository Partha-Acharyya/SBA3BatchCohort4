package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.CreditCard;
import com.wf.bootapp.ibs.entity.account;
import com.wf.bootapp.ibs.entity.recurringDeposit;

@Repository
public interface rdRepository extends JpaRepository<recurringDeposit, Long>{
		
}
