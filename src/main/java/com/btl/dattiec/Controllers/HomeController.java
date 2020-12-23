package com.btl.dattiec.Controllers;


import com.btl.dattiec.Models.Invoice;
import com.btl.dattiec.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = {"/", "/home"})
	public String goHome(Model model) {

		model.addAttribute("list",invoiceService.reportMonth());
		return "home";
	}

	@GetMapping(value ="/report-year")
	public String goReportYear(Model model){
		Map<Integer,Float> map = invoiceService.reportYear();

		Set<Integer> set = map.keySet();
		List<Integer> year = new ArrayList<>();
		List<Float> list = new ArrayList<>();

		for (Integer key : set) {
			year.add(key);
			list.add(map.get(key));
		}

		model.addAttribute("year",year);
		model.addAttribute("list",list);

		return "report-year";
	}
	@GetMapping(value ="/report-quarter")
	public String goReportQuarter(Model model){

		model.addAttribute("list",invoiceService.reportQuarter());

		return "report-quarter";
	}
}
