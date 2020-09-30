package com.customer.ms.dao;

import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {
	
	private static final Map<String, Customer> cusMap = new HashMap<String, Customer>();
	
	static {
		initCus();
	}

	private static void initCus() {
		
		Customer cus1 = new Customer("c01", "Suresh1", "PA");
		Customer cus2 = new Customer("c02", "Suresh2", "NJ");
		Customer cus3 = new Customer("c03", "Suresh3", "NY");
		
		cusMap.put(cus1.getCusId(), cus1);
		cusMap.put(cus2.getCusId(), cus2);
		cusMap.put(cus3.getCusId(), cus3);
			
	}

	public Customer getCustomer(String cusId) { 
		 		return cusMap.get(cusId); 
		 	} 
		
	public Customer addCustomer(Customer cus) { 
		 		cusMap.put(cus.getCusId(), cus); 
		 		return cus; 
		 	} 
			 
	public List<Customer> getAllCustomers() { 
		 		Collection<Customer> c = cusMap.values(); 
		 		List<Customer> list = new ArrayList<Customer>(); 
		 		list.addAll(c); 
		 		return list; 
		 	} 
	
	public void deleteCustomer(String cusId) { 
		 		 cusMap.remove(cusId); 
		 		 		 
		 	} 
		 	 
	public String updateCustomer(Customer cus) { 
		 		cusMap.replace(cus.getCusId(), cus); 
		 		return "Update Done ...."; 
		 	} 
}
