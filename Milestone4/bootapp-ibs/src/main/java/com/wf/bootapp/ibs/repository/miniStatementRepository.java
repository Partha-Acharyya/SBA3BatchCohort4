package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.account;
import com.wf.bootapp.ibs.entity.miniStatement;

@Repository
public interface miniStatementRepository extends JpaRepository<miniStatement, Long>{
	List<miniStatement> findByCustId(Long custId);
	
}


