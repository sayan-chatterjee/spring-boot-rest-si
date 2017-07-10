package com.pwc.demo.si.gateway;

import org.springframework.stereotype.Component;

import com.pwc.demo.model.Address;
import com.pwc.demo.model.Customer;

@Component
public interface SICustomerGateway {
	public Address fetchAddress(Customer customer);
}
