package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.AddBeneficiary;

@Repository
public interface AddBeneficiaryRepository extends JpaRepository<AddBeneficiary, Long> {

	List<AddBeneficiary> findByCustomerId(Long customerId);

	AddBeneficiary findByBeneficiaryAccountNo(Long beneficiaryAccountNo);

	@Transactional
	@Modifying
	@Query("delete from AddBeneficiary a where a.beneficiaryAccountNo=:beneficiaryAccountNo")
	void deleteByBeneficiaryAccountNo(@Param("beneficiaryAccountNo") Long beneficiaryAccountNo);

	boolean existsByBeneficiaryAccountNo(Long beneficiaryNo);

}
