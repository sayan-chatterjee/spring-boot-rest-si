package com.pwc.demo.activator;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.pwc.demo.model.Customer;
import com.pwc.demo.service.CustomerService;


@Component
public class CustomerActivator {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource
	CustomerService custService;

	public Message<?> getCustomer(Message<?> msg) {
		log.info("GET method ");
		
		List<Customer> custLst = custService.getAll();
		//Customer custLst  = custService.getAll();
		return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();
	}
	
	public Message<?> getCustomerById(Message<?> msg) {
		log.info("GET method ");
		Integer id = 1;
		Customer custLst = custService.getById(id);
		//Customer custLst  = custService.getAll();
		return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();
	}
	
	public Integer addCustomer(Message<Customer> msg){
		log.info("POST method");
		Integer id = custService.insert(msg.getPayload());
		return id;
	}
	
	public void put(Message<Customer> msg){
		log.info("PUT method");
		custService.change(msg.getPayload());
	}
	
	public void delete(Message<String>msg){
		log.info("DELETE method");
		int id = Integer.valueOf(msg.getPayload());
		custService.delete(id);
	}
}