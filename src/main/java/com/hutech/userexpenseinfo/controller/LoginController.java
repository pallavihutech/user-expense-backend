package com.hutech.userexpenseinfo.controller;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.userexpenseinfo.model.Login;
import com.hutech.userexpenseinfo.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/createlogin")
	public String postLogin(@RequestBody Login user) throws InterruptedException, ExecutionException {
		return loginService.createLogin(user);
	}
	
	@PostMapping("/login")
	public String enterLogin(@RequestBody Login user) throws ExecutionException, InterruptedException {
		return loginService.getLoginData(user);
	}

}