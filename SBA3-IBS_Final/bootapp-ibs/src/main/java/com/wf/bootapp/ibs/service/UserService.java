package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.wf.bootapp.ibs.dto.NewUser;
import com.wf.bootapp.ibs.dto.NewUserOutput;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.AccountStatement;
import com.wf.bootapp.ibs.entity.*;




public interface UserService {
	public List<NewUserOutput> fetchAllCustomers();
	public NewUserOutput fetchSingleCustomer(Long id);
	public NewUserOutput deleteSingleCustomer(Long id);
	public NewUserOutput saveCustomer(NewUser newuser);
	public NewUserOutput updateCustomer(Long id);
}
