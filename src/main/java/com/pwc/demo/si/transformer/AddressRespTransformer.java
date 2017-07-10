package com.pwc.demo.si.transformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pwc.demo.model.Address;

public class AddressRespTransformer {
	public static final Logger logger = LoggerFactory.getLogger(AddressTransformer.class);
	
	public Address transform(Address a) {
		if(a.getAddrLine1().equalsIgnoreCase("Address Line 1")){
			a.setAddrLine1("Transformed....");
		}
		return a;
	}
}
