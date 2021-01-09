package com.wf.bootapp.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.dto.PersonalLoanDto;

@Repository
public interface PersonalLoanRepository extends JpaRepository<PersonalLoanDto, Long>{

	

}
