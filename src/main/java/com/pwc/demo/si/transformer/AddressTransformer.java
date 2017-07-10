package com.pwc.demo.si.transformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import com.pwc.demo.model.Address;
import com.pwc.demo.model.Customer;

public class AddressTransformer{ // extends AbstractTransformer{

	public static final Logger logger = LoggerFactory.getLogger(AddressTransformer.class);
	
	/*@Override
	protected Object doTransform(Message<?> msg) throws Exception {
		// TODO Auto-generated method stub
		Customer c = (Customer) msg.getPayload();
		Address addr = new Address();
		addr.setAddrLine1("Plot 57, Block DN");
		addr.setAddrLine2("Salt Lake, Sector 5");
		c.setAddress(addr);
		return c;
	}*/
	
	public Customer transform(Customer c) {
		Address addr = new Address();
		addr.setAddrLine1("Plot 57, Block DN");
		addr.setAddrLine2("Salt Lake, Sector 5");
		c.setAddress(addr);
		System.out.println("Request Transformer :::" + c.getAddress().getAddrLine1());
		return c;
	}

	
}
