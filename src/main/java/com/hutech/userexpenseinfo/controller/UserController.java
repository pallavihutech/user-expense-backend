package com.hutech.userexpenseinfo.controller;

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

import com.hutech.userexpenseinfo.model.User;
import com.hutech.userexpenseinfo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getUser/{paid_by}")
	public User getUserData(@PathVariable String paid_by) throws ExecutionException, InterruptedException {
		return userService.getUserData(paid_by);
	}

	@PostMapping("/createUser")
	public String saveUser(@RequestBody User user) throws InterruptedException, ExecutionException {

		return userService.saveUser(user);

	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException {

		return userService.updateUser(user);

	}

	@DeleteMapping("/deleteUser/{paid_by}")
	public String deleteUse(@PathVariable String paid_by) throws ExecutionException, InterruptedException {
		return userService.deleteUser(paid_by);
	}

}
