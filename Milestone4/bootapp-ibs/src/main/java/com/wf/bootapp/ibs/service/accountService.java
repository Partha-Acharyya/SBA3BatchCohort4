package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.rdInputDto;
import com.wf.bootapp.ibs.dto.rdOutputDto;
import com.wf.bootapp.ibs.entity.account;
import com.wf.bootapp.ibs.entity.miniStatement;
import com.wf.bootapp.ibs.entity.*;




public interface accountService {
	public List<account> fetchAllaccounts(Long CustomerId);
	public rdOutputDto createRd(rdInputDto rdInputDto); 
	public List<miniStatement> fetchAlltransactions(Long custId);
	public List<Transferfunds> Transferfunds(Long CustomerId);
}
