package com.hutech.userexpenseinfo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.userexpenseinfo.model.UserExpense;
import com.hutech.userexpenseinfo.service.UserExpenseService;

@RestController
public class UserExpenseController {
	@Autowired
	private UserExpenseService userService;

	@GetMapping("/getUser/{expenseId}")
	public UserExpense getUserData(@PathVariable int expenseId) throws ExecutionException, InterruptedException {
		return userService.getUserData(expenseId);
	}

	@GetMapping(value = "/getAllData")
	List<UserExpense> getUser() throws ExecutionException,InterruptedException {
		return userService.findAll();

	}

	@PostMapping("/createUser")
	public String saveUser(@RequestBody UserExpense user) throws InterruptedException, ExecutionException {

		 userService.saveUser(user);
		 return"user created";

	}

	@PutMapping("/updateUser/{expenseId}")
	public String updateUser(@PathVariable  String expenseId,@RequestBody UserExpense user) throws InterruptedException, ExecutionException {

		return userService.updateUser(expenseId,user);

	}

	@DeleteMapping("/deleteUser/{expenseId}")
	public String deleteUser(@PathVariable String expenseId) throws ExecutionException, InterruptedException {
		return userService.deleteUser(expenseId);
	}

}
