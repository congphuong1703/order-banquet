package com.btl.dattiec.Service;

import com.btl.dattiec.Models.Food;

import java.util.List;

public interface FoodService {

	public void delete(Long id);

	public void save(Food food);

	public void update(Food food);

	public Food getById(Long id);

	public List<Food> findAll();


}
