package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;

@Repository
public interface MiniStatementRepository extends JpaRepository<MiniStatement, Long>{
	//List<MiniStatement> findByCustId(Long custId);

//	List<MiniStatement> findByCustIdOrderByIdDesc(Long custId);

//	List<MiniStatement> findAllByOrderByCustIdDesc(Long custId);
	@Query("select m from MiniStatement m where m.custId=:custId ORDER BY m.id DESC")
	List<MiniStatement> findByCustId(@Param("custId") Long custId);
}


