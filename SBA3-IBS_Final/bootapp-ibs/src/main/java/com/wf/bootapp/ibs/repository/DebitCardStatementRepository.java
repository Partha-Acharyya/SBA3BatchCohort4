package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.wf.bootapp.ibs.entity.DebitCardStatement;

@Repository
public interface DebitCardStatementRepository extends JpaRepository<DebitCardStatement,Long>{

	@Query("SELECT d FROM DebitCardStatement d  where debitCardNumber =:debitCardNumber and createDate BETWEEN :startDate AND :endDate")
	List<DebitCardStatement> findByDebitCardNumber(@Param("debitCardNumber") Long debitCardNumber,@Param("startDate") String startDate,@Param("endDate") String endDate);
	

}
