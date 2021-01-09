package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.Customer;


@Repository
public interface NewUserRepository extends JpaRepository<Customer, Long>{
//	List<Customer> findByCustomerId(Long id);

	
}
