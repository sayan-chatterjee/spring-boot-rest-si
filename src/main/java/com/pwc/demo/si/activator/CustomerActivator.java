package com.pwc.demo.si.activator;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.pwc.demo.model.Address;
import com.pwc.demo.model.Customer;
import com.pwc.demo.service.CustomerService;
import com.pwc.demo.si.gateway.SICustomerGateway;


@Component
public class CustomerActivator {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	SICustomerGateway siCustomerGateway;
	
	@Resource
	CustomerService custService;

	public Message<?> getCustomer(Message<?> msg) {
		log.info("GET method ");
		
		List<Customer> custLst = custService.getAll();
		Address a = siCustomerGateway.fetchAddress(custLst.get(0));				
		System.out.println(a.getAddrLine1()+"\n"+a.getAddrLine2());
		Customer c = custLst.get(0);
		c.setAddress(a);
		System.out.println("Final Address :::" + c.getAddress().getAddrLine1());
		return MessageBuilder.withPayload(c).copyHeadersIfAbsent(msg.getHeaders())
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