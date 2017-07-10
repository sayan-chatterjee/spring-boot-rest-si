package com.pwc.demo.si.rest.gateway;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.pwc.demo.model.Customer;

@Component
public interface CustomerGateway {
	@Payload("new java.util.Date()")
	public List<Customer> getCustomer();
	public Integer addCustomer(Customer customer);
	public Customer deleteCustomer(Customer customer);
}
