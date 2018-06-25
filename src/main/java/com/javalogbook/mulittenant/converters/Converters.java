package com.javalogbook.mulittenant.converters;

import com.javalogbook.mulittenant.dtos.CustomerDto;
import com.javalogbook.mulittenant.model.Customer;

public class Converters {

	public static CustomerDto convert(Customer source) {
		if (source == null) {
			return null;
		}

		return new CustomerDto(source.getId(), source.getCustomerName(), source.getCustomerAddress());
	}

	public static Customer convert(CustomerDto source) {
		if (source == null) {
			return null;
		}

		return new Customer(source.getId(), source.getCustomerName(), source.getCustomerAddress());
	}
}
