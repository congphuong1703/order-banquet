package com.btl.dattiec.ServiceImp;

import com.btl.dattiec.Models.Food;
import com.btl.dattiec.Models.Invoice;
import com.btl.dattiec.Models.Lobby;
import com.btl.dattiec.Repositories.InvoiceRepository;
import com.btl.dattiec.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceServiceImp implements InvoiceService {

	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceServiceImp(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public void delete(Long id) {
		Invoice invoice = this.getById(id);
		invoiceRepository.delete(invoice);
	}

	@Override
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	@Override
	public void payment(Long id) {
		Invoice newInvoice = this.getById(id);
		if (newInvoice.isStatus())
			return;

		Calendar calOrder = Calendar.getInstance();
		calOrder.setTime(newInvoice.getDateOfOrder());

		Calendar calPay = Calendar.getInstance(TimeZone.getDefault());

		int year = calPay.get(Calendar.YEAR) - calOrder.get(Calendar.YEAR);
		int month = calPay.get(Calendar.MONTH) - calOrder.get(Calendar.MONTH);
		int day = calPay.get(Calendar.DAY_OF_MONTH) - calOrder.get(Calendar.DAY_OF_MONTH);

		day += year * 365 + month * 30;

		if (day > 0) {
			float total = newInvoice.getTotal() + (day * (newInvoice.getTotal() / 100));
			newInvoice.setTotal(total);
		}

		newInvoice.setStatus(true);
		newInvoice.setDateOfPayment(new Date());

		this.save(newInvoice);
	}

	@Override
	public Invoice getById(Long id) {
		return invoiceRepository.getById(id);
	}

	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> search(String keyword) {
		if (keyword == null || keyword == "")
			return this.findAll();
		return this.findByNameCustomer(keyword);
	}

	@Override
	public List<Invoice> findByNameCustomer(String name) {
		return this.invoiceRepository.findByCustomerName(name);
	}

	@Override
	public List<Float> reportMonth() {
		List<Float> list = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			list.add((float) 0);
		}
		for (Invoice invoice : invoiceRepository.findAll()) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(invoice.getDateOfOrder());
			int month = calendar.get(Calendar.MONTH);
			System.out.println(month);
			switch (month) {
				case 0:
					Float total = list.get(0);
					total += invoice.getTotal();
					list.set(0, total);
					break;
				case 1:
					total = list.get(1);
					total += invoice.getTotal();
					list.set(1, total);
					break;
				case 2:
					total = list.get(2);
					total += invoice.getTotal();
					list.set(2, total);
					break;
				case 3:
					total = list.get(3);
					total += invoice.getTotal();
					list.set(3, total);
					break;
				case 4:
					total = list.get(4);
					total += invoice.getTotal();
					list.set(4, total);
					break;
				case 5:
					total = list.get(5);
					total += invoice.getTotal();
					list.set(5, total);
					break;
				case 6:
					total = list.get(6);
					total += invoice.getTotal();
					list.set(6, total);
					break;
				case 7:
					total = list.get(7);
					total += invoice.getTotal();
					list.set(7, total);
					break;
				case 8:
					total = list.get(8);
					total += invoice.getTotal();
					list.set(8, total);
					break;
				case 9:
					total = list.get(9);
					total += invoice.getTotal();
					list.set(9, total);
					break;
				case 10:
					total = list.get(10);
					total += invoice.getTotal();
					list.set(10, total);
					break;
				case 11:
					total = list.get(11);
					total += invoice.getTotal();
					list.set(11, total);
					break;
			}
		}
		return list;
	}

	@Override
	public List<Float> reportQuarter() {
		List<Float> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			list.add((float) 0);
		}
		for (Invoice invoice : invoiceRepository.findAll()) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(invoice.getDateOfOrder());
			int month = calendar.get(Calendar.MONTH);
			System.out.println(month);
			if (month >= 0 && month <= 2) {
				Float total = list.get(0);
				total += invoice.getTotal();
				list.set(0, total);
			} else if (month > 2 && month <= 5) {
				Float total = list.get(1);
				total += invoice.getTotal();
				list.set(1, total);
			} else if (month > 5 && month <= 8) {
				Float total = list.get(2);
				total += invoice.getTotal();
				list.set(2, total);
			} else {
				Float total = list.get(3);
				total += invoice.getTotal();
				list.set(3, total);
			}
		}
		return list;
	}

	@Override
	public Map<Integer, Float> reportYear() {
		Map<Integer, Float> map = new HashMap<>();
		for (Invoice invoice : invoiceRepository.findAll()) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(invoice.getDateOfOrder());
			int year = calendar.get(Calendar.YEAR);

			if(map.get(year) == null){
				map.put(year, (float) 0);
			}
			Float total = map.get(year);
			total += invoice.getTotal();
			map.put(year, total);
		}
		return map;
	}

}
