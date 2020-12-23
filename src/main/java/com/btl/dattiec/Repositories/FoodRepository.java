package com.btl.dattiec.Repositories;

import com.btl.dattiec.Models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {

	public List<Food> findAll();

	public Food getById(Long id);
}
