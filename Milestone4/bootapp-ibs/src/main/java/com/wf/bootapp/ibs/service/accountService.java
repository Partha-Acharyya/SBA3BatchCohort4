package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.entity.account;



public interface accountService {
	public List<account> fetchAllaccounts(Long CustomerId);
}
