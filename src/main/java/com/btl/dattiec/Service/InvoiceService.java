package com.btl.dattiec.Service;

import com.btl.dattiec.Models.Invoice;

import java.util.List;
import java.util.Map;

public interface InvoiceService {

	public void delete(Long id);

	public void save(Invoice invoice);

	public void payment(Long id);

	public Invoice getById(Long id);

	public List<Invoice> findAll();

	public List<Invoice> search(String keyword);

	public List<Invoice> findByNameCustomer(String name);

	public List<Float> reportQuarter();

	public List<Float> reportMonth();

	public Map<Integer, Float> reportYear();

}