package com.pwc.demo.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pwc.demo.model.Customer;

@Service
public class CustomerService {
	
	Map<Integer, Customer> customerStorage = new LinkedHashMap<Integer, Customer>();
	
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@PostConstruct
	public void init(){
		Customer jack = new Customer(1, "Jack", 20);
		Customer peter = new Customer(2, "Peter", 30);
		Customer sayan = new Customer(3, "Sayan", 40);
		Customer sourav = new Customer(4, "Sourav", 50);
		Customer biman = new Customer(5, "Biman", 60);
		Customer rahul = new Customer(6, "Rahul", 70);
		
		
		customerStorage.put(jack.getId(), jack);
		customerStorage.put(peter.getId(), peter);
		customerStorage.put(sayan.getId(), sayan);
		customerStorage.put(sourav.getId(), sourav);
		customerStorage.put(biman.getId(), biman);
		customerStorage.put(rahul.getId(), rahul);
	}
	
	public Integer insert(Customer customer){
		Integer id = 0;
		log.info("Customers after POST:");
		for (Map.Entry<Integer, Customer> entry : customerStorage.entrySet()) {
			log.info(entry.getValue().toString());
			id =  entry.getValue().getId();
			log.info("id :: ",id);
		}
		customer.setId(id+1);
		customerStorage.put(id+1, customer);
		return id+1;
	}
	
	public List<Customer> /*Customer*/ getAll(/*Integer id*/){
		
		List<Customer> result = customerStorage.entrySet().stream()
		        .map(entry -> entry.getValue())
		        .collect(Collectors.toList());
		        
		  return result;
		
		
		//return customerStorage.get(id);
	}
	
	public Customer getById(Integer id){
		
		return customerStorage.get(id);
	}
	
	public void delete(int id){
		try{
			customerStorage.remove(id);			
		}catch(Exception e){
		}

	}
	
	public void change(Customer newCust){
		customerStorage.put(newCust.getId(), newCust);
		log.info("Customers after PUT:");
		for (Map.Entry<Integer, Customer> entry : customerStorage.entrySet()) {
			log.info(entry.getValue().toString());
		}
	}
}