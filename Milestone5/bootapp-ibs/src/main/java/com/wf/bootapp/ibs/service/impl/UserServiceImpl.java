package com.wf.bootapp.ibs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.bootapp.ibs.dto.Newuser;
import com.wf.bootapp.ibs.dto.Newuseroutput;
import com.wf.bootapp.ibs.entity.Customer;
import com.wf.bootapp.ibs.repository.NewUserRepository;
import com.wf.bootapp.ibs.repository.UserRepository;
import com.wf.bootapp.ibs.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private NewUserRepository repository;
	
	private Customer convertnewUserInputDtotoEntity(Newuser usertoregister){
		Customer newCustomer= new Customer();
		newCustomer.setBirthday(usertoregister.getBirthday());
		newCustomer.setCity(usertoregister.getCity());
		newCustomer.setEmail(usertoregister.getEmail());
		newCustomer.setFirstName(usertoregister.getFirstName());
		newCustomer.setLastName(usertoregister.getLastName());
		newCustomer.setLocation(usertoregister.getLocation());
		newCustomer.setMobileNumber(usertoregister.getMobileNumber());
		newCustomer.setStatus("Un-Registered");
		return newCustomer;
	}
	
	private Newuseroutput convertUserEntitytoOutputDto(Customer user){
		Newuseroutput registeruser= new Newuseroutput();
		registeruser.setBirthday(user.getBirthday());
		registeruser.setCity(user.getCity());
		registeruser.setEmail(user.getEmail());
		registeruser.setFirstName(user.getFirstName());
		registeruser.setId(user.getId());
		registeruser.setLastName(user.getLastName());
		registeruser.setLocation(user.getLocation());
		registeruser.setMobileNumber(user.getMobileNumber());
		registeruser.setStatus(user.getStatus());
		
		return registeruser;
	}

	@Override
	public List<Newuseroutput> fetchAllCustomers() {
		List<Customer> customers= this.repository.findAll();
		
		List<Newuseroutput> newuseroutputdto= customers.stream().map(this:: convertUserEntitytoOutputDto)
											  .collect(Collectors.toList());
		return newuseroutputdto;
	}

	@Override
	public Newuseroutput fetchSingleCustomer(Long id) {
		if(this.repository.existsById(id)) {
			Customer customer = this.repository.findById(id).orElse(null);
			Newuseroutput newuseroutput = this.convertUserEntitytoOutputDto(customer);
			return newuseroutput;
		}
		return null;
	}
	
	@Override
	public Newuseroutput updateCustomer(Long id) {
		if(this.repository.existsById(id)) {
			Customer customer = this.repository.findById(id).orElse(null);
			customer.setPassword("pwd"+id);
			customer.setStatus("Registered");
			Customer updatedcustomer = this.repository.save(customer);
			Newuseroutput updateduseroutput = this.convertUserEntitytoOutputDto(updatedcustomer);
			return updateduseroutput;
		}
		return null;
	}
	
	@Override
	public Newuseroutput deleteSingleCustomer(Long id) {
		if(this.repository.existsById(id)) {
			Newuseroutput user = this.fetchSingleCustomer(id);
			this.repository.deleteById(id);
			return user;
		}
		return null;
	}

	@Override
	public Newuseroutput saveCustomer(Newuser newuser) {
		// convert input dto to entity
		Customer cust= this.convertnewUserInputDtotoEntity(newuser);
		// save into DB, returns newly added record
		Customer newcust= this.repository.save(cust);
		//System.out.println(newcust.getCity());
		// convert entity to dto 
		Newuseroutput newuseroutput = this.convertUserEntitytoOutputDto(newcust);
		return newuseroutput;
	}
	
	
	

}
