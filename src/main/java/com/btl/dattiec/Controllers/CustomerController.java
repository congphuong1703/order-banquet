package com.btl.dattiec.Controllers;

import com.btl.dattiec.Models.Customer;
import com.btl.dattiec.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String goCustomer(Model model) {

		List<Customer> customers = customerService.findAll();

		model.addAttribute("customers", customers);
		return "customer";
	}

	@GetMapping("/get")
	public String getCustomer(@RequestParam(value = "id") Long id, Model model) {

		Customer customer = customerService.getById(id);
		model.addAttribute("customer", customer);

		return "customer-detail";
	}

	@PostMapping("/add")
	public String addCustomer(@ModelAttribute(value = "customer") Customer customer) {

		customerService.save(customer);
		return "redirect:/customer";
	}

	@GetMapping("/add")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "add-customer";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam(value = "id") Long id) {
		customerService.delete(id);
		return "redirect:/customer";
	}

	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute(value = "customer") Customer customer) {

		customerService.update(customer);
		return "redirect:/customer";
	}
}
