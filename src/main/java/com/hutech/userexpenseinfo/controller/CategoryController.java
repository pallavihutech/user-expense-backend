package com.hutech.userexpenseinfo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.userexpenseinfo.model.Category;
import com.hutech.userexpenseinfo.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("/getCategory/{categoryId}")
	public Category findByCategory(@PathVariable String categoryId) throws ExecutionException, InterruptedException {
		return categoryService.findByCategory(categoryId);
	}
	@GetMapping(value = "/getAllCategory")
	List<Category> getCategory() throws ExecutionException, InterruptedException{
	return categoryService.findAll();

	}

}
