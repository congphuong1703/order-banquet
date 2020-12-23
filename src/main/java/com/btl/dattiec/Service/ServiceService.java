package com.btl.dattiec.Service;

import com.btl.dattiec.Models.Service;

import java.util.List;

public interface ServiceService {


	public void delete(Long id);

	public void save(Service service);

	public void update(Service service);

	public Service getById(Long id);

	public List<Service> findAll();
}
