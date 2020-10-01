package com.customer.ms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;
	
	// URL - http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		return "Greeting from Spring Boot...1.0";
	}
	
	// URL - http://localhost:8080/customers 
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public List<Customer> getCustomers() { 
		List<Customer> list = customerDAO.getAllCustomers(); 
		return list; 
		} 
	
	// URL - http://localhost:8080/customers/{cusId} 
	@RequestMapping(value = "/customers/{cusId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public Customer getCustomer(@PathVariable("cusId") String cusId) { 
		return customerDAO.getCustomer(cusId); 
	 	}  

	// URL - POST http://localhost:8080/customers} 
	@RequestMapping(value = "/customers", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }) 
	public Customer addCustomer(@RequestBody Customer customer) { 
		return customerDAO.addCustomer(customer); 
		} 

	// URL - PUT http://localhost:8080/customer}
    @RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateCustomer(@RequestBody Customer cus) {
        return customerDAO.updateCustomer(cus);
    }

 

    // URL - DELETE http://localhost:8080/customer/{cusId} - deleteCustomer
    @RequestMapping(value = "/customer/{cusId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("cusId") String cusId) {
        customerDAO.deleteCustomer(cusId);
    }
	
    @RequestMapping(value= "/mongoCustomers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomerM> getMongoCustomers(){
        List<CustomerM> list = customerService.findAll();
        return list;
    }
    
    @RequestMapping(value= "/mongoCustomer/{cusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerM getMongoCustomer(@PathVariable("cusId") String cusId){
        return customerService.findById(cusId);
    }
    
    @RequestMapping(value = "/mongoCustomer", method = RequestMethod.POST , produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerM addMongoCustomer(@RequestBody CustomerM customer){
        return customerService.addCustomer(customer);
    }
    
    @RequestMapping(value = "/mongoCustomer/{cusId}", method = RequestMethod.DELETE )
    public String deleteMongoCustomer(@PathVariable("cusId") String cusId) {
        return customerService.deleteCustomer(cusId);
    }  
    
    @RequestMapping(value = "/mongoCustomeru", method = RequestMethod.POST , produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerM updateMongoCustomer(@RequestBody CustomerM customer){
        return customerService.updateCustomer(customer);
    }
    
}
