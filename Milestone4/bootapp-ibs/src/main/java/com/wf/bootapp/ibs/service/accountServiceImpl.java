package com.wf.bootapp.ibs.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.entity.account;
import com.wf.bootapp.ibs.repository.userRepository;



@Service

public class accountServiceImpl implements accountService {
	
	@Autowired
	userRepository Repository;

	@Override
	//@PostConstruct
	//@Transactional
	public List<account> fetchAllaccounts(Long CustomerId) {
	
		List<account> accounts = this.Repository.findByCustomerId(CustomerId);
		
		return accounts;
	}

}

