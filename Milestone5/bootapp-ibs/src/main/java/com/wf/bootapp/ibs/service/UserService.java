package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.Newuser;
import com.wf.bootapp.ibs.dto.Newuseroutput;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;
import com.wf.bootapp.ibs.entity.*;




public interface UserService {
	public List<Newuseroutput> fetchAllCustomers();
	public Newuseroutput fetchSingleCustomer(Long id);
	public Newuseroutput saveCustomer(Newuser newuser);
}
