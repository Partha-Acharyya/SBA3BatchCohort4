package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.NewUser;
import com.wf.bootapp.ibs.dto.NewUserOutput;
import com.wf.bootapp.ibs.entity.Customer;
import com.wf.bootapp.ibs.repository.NewUserRepository;
import com.wf.bootapp.ibs.repository.UserRepository;
import com.wf.bootapp.ibs.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private NewUserRepository repository;
	
	private Customer convertUserInputDtotoEntity(NewUser usertoregister){
		Customer newCustomer= new Customer();
		newCustomer.setBirthday(usertoregister.getBirthday());
		newCustomer.setCity(usertoregister.getCity());
		newCustomer.setEmail(usertoregister.getEmail());
		newCustomer.setFirstName(usertoregister.getFirstName());
		newCustomer.setLastName(usertoregister.getLastName());
		newCustomer.setLocation(usertoregister.getLocation());
		newCustomer.setMobileNumber(usertoregister.getMobileNumber());
		
		return newCustomer;
	}
	
	private NewUserOutput convertUserEntitytoOutputDto(Customer user){
		NewUserOutput registeruser= new NewUserOutput();
		registeruser.setBirthday(user.getBirthday());
		registeruser.setCity(user.getCity());
		registeruser.setEmail(user.getEmail());
		registeruser.setFirstName(user.getFirstName());
		registeruser.setId(user.getId());
		registeruser.setLastName(user.getLastName());
		registeruser.setLocation(user.getLocation());
		registeruser.setMobileNumber(user.getMobileNumber());
		
		return registeruser;
	}

	@Override
	public List<NewUserOutput> fetchAllCustomers() {
		List<Customer> customers= this.repository.findAll();
		
		List<NewUserOutput> newuseroutputdto= customers.stream().map(this:: convertUserEntitytoOutputDto)
											  .collect(Collectors.toList());
		return newuseroutputdto;
	}

	@Override
	public NewUserOutput fetchSingleCustomer(Long id) {
		if(this.repository.existsById(id)) {
			Customer customer = this.repository.findById(id).orElse(null);
			NewUserOutput newuseroutput = this.convertUserEntitytoOutputDto(customer);
			return newuseroutput;
		}
		return null;
	}

	@Override
	public NewUserOutput saveCustomer(NewUser newuser) {
		// convert input dto to entity
		Customer cust= this.convertUserInputDtotoEntity(newuser);
		// save into DB, returns newly added record
		Customer newcust= this.repository.save(cust);
		System.out.println(newcust.getCity());
		// convert entity to dto 
		NewUserOutput newuseroutput = this.convertUserEntitytoOutputDto(newcust);
		return newuseroutput;
	}
	
	
	

}
