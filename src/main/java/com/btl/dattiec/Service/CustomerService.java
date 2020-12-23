package com.btl.dattiec.Service;

import com.btl.dattiec.Models.Customer;

import java.util.List;

public interface CustomerService {

	public void delete(Long id);

	public void save(Customer customer);

	public void update(Customer customer);

	public Customer getById(Long id);

	public List<Customer> findAll();

}
