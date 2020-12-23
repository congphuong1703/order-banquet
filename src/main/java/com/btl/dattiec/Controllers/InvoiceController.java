package com.btl.dattiec.Controllers;

import com.btl.dattiec.Models.Food;
import com.btl.dattiec.Models.Invoice;
import com.btl.dattiec.Models.Lobby;
import com.btl.dattiec.Models.Service;
import com.btl.dattiec.Service.FoodService;
import com.btl.dattiec.Service.InvoiceService;
import com.btl.dattiec.Service.LobbyService;
import com.btl.dattiec.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {


	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private LobbyService lobbyService;

	@GetMapping
	public String goInvoice(Model model, @Param("keyword") String keyword) {
		List<Invoice> invoices = invoiceService.search(keyword);
		model.addAttribute("invoices", invoices);
		model.addAttribute("keyword", keyword);
		return "invoice";
	}

	@GetMapping("/get")
	public String getInvoice(@RequestParam("id") Long id, Model model) {
		Invoice invoice = this.invoiceService.getById(id);
		model.addAttribute("invoice", invoice);
		model.addAttribute("services",invoice.getService());
		model.addAttribute("lobbies",invoice.getLobby());
		model.addAttribute("foods",invoice.getFood());
		return "invoice-detail";
	}

	@GetMapping("/delete")
	public String deleteInvoice(@RequestParam("id") Long id) {
		invoiceService.delete(id);
		return "redirect:/invoice";
	}

	@PostMapping("/add")
	public String addInvoice(@ModelAttribute(value = "invoice") Invoice invoice) {
		invoice.setStatus(false);
		float total = 0;

		for(Food food : invoice.getFood()){
			total += food.getPrice();
		}

		for(Lobby lobby : invoice.getLobby()){
			total += lobby.getPrice();
		}

		for(Service service : invoice.getService()){
			total += service.getPrice();
		}

		invoice.setTotal(total);
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}

	@GetMapping("/add")
	public String addInvoice(Model model) {
		Invoice invoice = new Invoice();
		model.addAttribute("invoice", invoice);
		model.addAttribute("foods", foodService.findAll());
		model.addAttribute("lobbies", lobbyService.findAll());
		model.addAttribute("services", serviceService.findAll());
		return "add-invoice";
	}


	@GetMapping("/payment")
	public String payment(@RequestParam("id") Long id) {
		invoiceService.payment(id);
		return "redirect:/invoice";
	}


}
