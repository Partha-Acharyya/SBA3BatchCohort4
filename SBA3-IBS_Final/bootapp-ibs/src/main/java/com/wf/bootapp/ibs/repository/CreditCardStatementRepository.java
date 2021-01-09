package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.CreditCardStatement;

@Repository
public interface CreditCardStatementRepository extends JpaRepository<CreditCardStatement,Long>{

	@Query("SELECT c FROM CreditCardStatement c  where creditCardNumber =:creditCardNumber and createDate BETWEEN :startDate AND :endDate")
	List<CreditCardStatement> findByCreditCardNumber(@Param("creditCardNumber") Long creditCardNumber,@Param("startDate") String startDate,@Param("endDate") String endDate);
	

}
