package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;

@Repository
public interface MiniStatementRepository extends JpaRepository<MiniStatement, Long>{
	List<MiniStatement> findByCustId(Long custId);
	
}


