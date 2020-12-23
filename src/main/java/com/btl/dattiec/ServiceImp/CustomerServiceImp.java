package com.btl.dattiec.ServiceImp;

import com.btl.dattiec.Models.Customer;
import com.btl.dattiec.Repositories.CustomerRepository;
import com.btl.dattiec.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	private CustomerServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void delete(Long id) {
		Customer customer = this.getById(id);
		customerRepository.delete(customer);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		Customer newCustomer = this.getById(customer.getId());
		newCustomer.setAddress(customer.getAddress());
		newCustomer.setName(customer.getName());
		newCustomer.setCode(customer.getCode());
		newCustomer.setNote(customer.getNote());
		newCustomer.setPhoneNumber(customer.getPhoneNumber());
		this.save(newCustomer);
	}

	@Override
	public Customer getById(Long id) {
		return customerRepository.getById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
