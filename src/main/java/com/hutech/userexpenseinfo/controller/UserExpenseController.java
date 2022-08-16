package com.hutech.userexpenseinfo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.userexpenseinfo.model.UserExpense;
import com.hutech.userexpenseinfo.service.UserExpenseService;

@RestController
public class UserExpenseController {
	@Autowired
	private UserExpenseService userService;

	@GetMapping("/getUser/{expenseId}")
	public ResponseEntity<UserExpense> getUserData(@PathVariable String expenseId)
			throws ExecutionException, InterruptedException {

		return new ResponseEntity<UserExpense>(userService.getUserData(expenseId), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllData")
	public ResponseEntity<List<UserExpense>> getUser() throws ExecutionException, InterruptedException {
		return new ResponseEntity<List<UserExpense>>(userService.findAll(), HttpStatus.OK);

	}

	@PostMapping("/createExpense")
	public ResponseEntity<String> saveUser(@RequestBody UserExpense user)
			throws InterruptedException, ExecutionException {
		String usExpense = userService.saveUser(user);
		return new ResponseEntity<String>("ExpenseInfo record Created", HttpStatus.CREATED);

	}

	@PutMapping("/updateUser/{expenseId}")
	public ResponseEntity<String> updateUser(@PathVariable String expenseId, @RequestBody UserExpense user)
			throws InterruptedException, ExecutionException {
		String uExpense = userService.updateUser(expenseId, user);

		return new ResponseEntity<String>("Update record Successfully ", HttpStatus.CREATED);
	

	}
	

	@DeleteMapping("/deleteUser/{expenseId}")
	public String deleteUser(@PathVariable String expenseId) throws ExecutionException, InterruptedException {

		userService.deleteUser(expenseId);
		return "ExpenseInfo has deleted for the ID:" + expenseId;
	}

}
