package com.btl.dattiec.Controllers;


import com.btl.dattiec.Models.Service;
import com.btl.dattiec.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@GetMapping
	public String goService(Model model) {

		List<Service> services = serviceService.findAll();

		model.addAttribute("services", services);
		return "service";
	}

	@GetMapping("/get")
	public String getService(@RequestParam(value = "id") Long id, Model model) {

		Service service = serviceService.getById(id);
		model.addAttribute("service", service);

		return "service-detail";
	}

	@PostMapping("/add")
	public String addService(@ModelAttribute(value = "service") Service service) {

		serviceService.save(service);
		return "redirect:/service";
	}

	@GetMapping("/add")
	public String addService(Model model) {
		Service service = new Service();
		model.addAttribute("service", service);

		return "add-service";
	}

	@GetMapping("/delete")
	public String deleteService(@RequestParam(value = "id") Long id) {
		serviceService.delete(id);
		return "redirect:/service";
	}

	@PostMapping("/update")
	public String updateService(@ModelAttribute(value = "service") Service service) {

		serviceService.update(service);
		return "redirect:/service";
	}
}
