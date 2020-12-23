package com.btl.dattiec.Repositories;

import com.btl.dattiec.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

	public List<Service> findAll();

	public Service getById(Long id);

}
