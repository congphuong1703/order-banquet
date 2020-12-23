package com.btl.dattiec.ServiceImp;

import com.btl.dattiec.Models.Food;
import com.btl.dattiec.Repositories.FoodRepository;
import com.btl.dattiec.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService {

	private FoodRepository foodRepository;

	@Autowired
	private FoodServiceImp(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	@Override
	public void delete(Long id) {
		Food food = this.getById(id);
		foodRepository.delete(food);
	}

	@Override
	public void save(Food food) {
		foodRepository.save(food);
	}

	@Override
	public void update(Food food) {
		Food newFood = this.getById(food.getId());
		newFood.setCode(food.getCode());
		newFood.setName(food.getName());
		newFood.setNote(food.getNote());
		newFood.setPrice(food.getPrice());
		newFood.setType(food.getType());
		this.save(newFood);
	}

	@Override
	public Food getById(Long id) {
		return foodRepository.getById(id);
	}

	@Override
	public List<Food> findAll() {
		return foodRepository.findAll();
	}
}
