package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.CreditCardEligibility;


@Repository
public interface CreditCardEligibilityRepository extends JpaRepository<CreditCardEligibility,Long>{

	List<CreditCardEligibility> findByStatus(String status);

}
