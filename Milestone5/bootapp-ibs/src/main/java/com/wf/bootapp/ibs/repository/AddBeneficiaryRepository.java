package com.wf.bootapp.ibs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.AddBeneficiary;



@Repository
public interface AddBeneficiaryRepository extends JpaRepository<AddBeneficiary, Long>{
	
	List<AddBeneficiary> findByCustomerId(Long customerId);



}
