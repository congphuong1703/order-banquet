package com.btl.dattiec.Controllers;

import com.btl.dattiec.Models.Food;
import com.btl.dattiec.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping
	public String goFood(Model model) {

		List<Food> foods = foodService.findAll();

		model.addAttribute("foods", foods);
		return "food";
	}

	@GetMapping("/get")
	public String getFood(@RequestParam(value = "id") Long id, Model model) {

		Food food = foodService.getById(id);
		model.addAttribute("food", food);

		return "food-detail";
	}

	@PostMapping("/add")
	public String addFood(@ModelAttribute(value = "food") Food food) {

		foodService.save(food);
		return "redirect:/food";
	}

	@GetMapping("/add")
	public String addFood(Model model) {
		Food food = new Food();
		model.addAttribute("food", food);

		return "add-food";
	}

	@GetMapping("/delete")
	public String deleteFood(@RequestParam(value = "id") Long id) {
		foodService.delete(id);
		return "redirect:/food";
	}

	@PostMapping("update")
	public String updateFood(@ModelAttribute(value = "food") Food food) {

		foodService.update(food);
		return "redirect:/food";
	}
}
