package com.btl.dattiec.Repositories;

import com.btl.dattiec.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	public List<Customer> findAll();

	public Customer getById(Long id);

	public List<Customer> findByName(String name);

	public List<Customer> findByPhoneNumber(String phoneNumber);
}
