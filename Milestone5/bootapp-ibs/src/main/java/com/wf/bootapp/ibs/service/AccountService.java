package com.wf.bootapp.ibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.AddBeneficiaryInputDto;
import com.wf.bootapp.ibs.dto.AddBeneficiaryOutputDto;
import com.wf.bootapp.ibs.dto.RdInputDto;
import com.wf.bootapp.ibs.dto.RdOutputDto;
import com.wf.bootapp.ibs.entity.Account;
import com.wf.bootapp.ibs.entity.MiniStatement;
import com.wf.bootapp.ibs.entity.*;




public interface AccountService {
	public List<Account> fetchAllaccounts(Long CustomerId);
	public RdOutputDto createRd(RdInputDto rdInputDto); 
	public List<MiniStatement> fetchAlltransactions(Long custId);
	public List<Transferfunds> Transferfunds(Long CustomerId);
	public List<AddBeneficiary> fetchAllBeneficiaries(Long customerId);
	public AddBeneficiaryOutputDto addBeneficiary(AddBeneficiaryInputDto AddBeneficiaryInputDto,Long id);
	public List<AddBeneficiaryOutputDto> BeneficiaryList(Long id);
	public AddBeneficiaryOutputDto ViewOrDeleteListOfBeneficiariesAdded(Long id);
	public List<AddBeneficiaryOutputDto> getAllibsBeneficiaries(Long customerId);

}
