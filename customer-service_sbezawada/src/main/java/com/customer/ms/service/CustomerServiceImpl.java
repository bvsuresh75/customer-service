package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRespository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRespository customerRepository;
	
    public List<CustomerM> findAll() {
        return customerRepository.findAll();
    }
	
    public CustomerM findById(String cusid) {

        Optional<CustomerM> opt = customerRepository.findById(cusid);
        if (opt.isPresent()) {
            return opt.get();
        } else
            return null;
    }
	public CustomerM addCustomer(CustomerM customerM) {
	        return customerRepository.save(customerM);
	    }

	@Override
	public CustomerM updateCustomer(CustomerM customerM) {
		// TODO Auto-generated method stub
		return customerRepository.save(customerM);
	}

	@Override
	public String deleteCustomer(String cusId) {
		// TODO Auto-generated method stub
		 Optional<CustomerM> opt = customerRepository.findById(cusId);
	        if (opt.isPresent()) {
	        	customerRepository.deleteById(cusId);
	        	return "Deleted .... ";
	        } else
	            return "Not Found ...";
	}
}
