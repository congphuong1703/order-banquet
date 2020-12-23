package com.btl.dattiec.Repositories;

import com.btl.dattiec.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

	public List<Invoice> findAll();

	public Invoice getById(Long id);

	public List<Invoice> findByCustomerName(String name);

}
