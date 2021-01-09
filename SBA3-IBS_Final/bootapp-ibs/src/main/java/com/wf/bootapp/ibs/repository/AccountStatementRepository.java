package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.AccountStatement;
import com.wf.bootapp.ibs.entity.CreditCardStatement;

@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long>{

	@Query("select m from AccountStatement m where m.customerId=:customerId ORDER BY m.id DESC")
	List<AccountStatement> findByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT c FROM AccountStatement c  where accountNumber =:accountNumber and createDate BETWEEN :startDate AND :endDate")
	List<AccountStatement> findByAccountNumber(@Param("accountNumber") Long accountNumber,@Param("startDate") String startDate,@Param("endDate") String endDate);
}


