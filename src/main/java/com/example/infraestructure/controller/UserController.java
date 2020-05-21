package com.example.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.domain.User;
import com.example.core.usecase.CreateUserUseCase;
import com.example.infraestructure.response.Response;

@RestController
@RequestMapping("/users")
public class UserController  {
	
	private CreateUserUseCase createUser;
	
	public UserController(CreateUserUseCase createUser) {
		super();
		this.createUser = createUser;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addUser(@RequestBody User restUser) {
		createUser.execute(restUser);
		return new ResponseEntity<Response>(new Response("Successfully Added"), HttpStatus.CREATED);
	}

}
