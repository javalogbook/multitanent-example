package com.javalogbook.mulittenant.dtos;

public class CustomerDto {
	private Long id;
	private String customerName;
	private String customerAddress;

	public CustomerDto(Long id, String customerName, String customerAddress) {
		this.id = id;
		this.customerAddress = customerAddress;
		this.customerName = customerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
