package com.btl.dattiec.ServiceImp;

import com.btl.dattiec.Models.Service;
import com.btl.dattiec.Repositories.ServiceRepository;
import com.btl.dattiec.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImp implements ServiceService {

	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceServiceImp(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@Override
	public void delete(Long id) {
		Service service = this.getById(id);
		this.serviceRepository.delete(service);
	}

	@Override
	public void save(Service service) {
		this.serviceRepository.save(service);
	}

	@Override
	public void update(Service service) {
		Service newService = this.getById(service.getId());
		newService.setCode(service.getCode());
		newService.setName(service.getName());
		newService.setNote(service.getNote());
		newService.setPrice(service.getPrice());
		newService.setType(service.getType());
		this.serviceRepository.save(newService);
	}

	@Override
	public Service getById(Long id) {
		return this.serviceRepository.getById(id);
	}

	@Override
	public List<Service> findAll() {
		return this.serviceRepository.findAll();
	}
}
