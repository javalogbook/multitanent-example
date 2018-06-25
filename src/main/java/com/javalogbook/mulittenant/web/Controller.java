package com.javalogbook.mulittenant.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javalogbook.mulittenant.converters.Converters;
import com.javalogbook.mulittenant.dtos.CustomerDto;
import com.javalogbook.mulittenant.model.Customer;
import com.javalogbook.mulittenant.repository.CustomerRepository;

@RestController
public class Controller {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<CustomerDto> getAll(HttpServletRequest httpRequest) throws IOException {
		return StreamSupport.stream(customerRepository.findAll().spliterator(), false).map(Converters::convert)
				.collect(Collectors.toList());
	}

	@GetMapping("/customers/{id}")
	public CustomerDto get(@PathVariable("id") long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			return Converters.convert(optional.get());
		}
		return null;
	}

	@PostMapping("/customers")
	public CustomerDto post(@RequestBody CustomerDto customer) {
		Customer source = Converters.convert(customer);
		Customer result = customerRepository.save(source);
		return Converters.convert(result);
	}

	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable("id") long id) {
		customerRepository.deleteById(id);
	}
}
