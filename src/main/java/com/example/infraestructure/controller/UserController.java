package com.example.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.usecase.CreateUserUseCase;
import com.example.infraestructure.controller.rest.RestUser;
import com.example.infraestructure.converter.Converter;
import com.example.infraestructure.response.Response;

@RestController
@RequestMapping("/users")
public class UserController  {
	
	private CreateUserUseCase createUser;
	
	private Converter convert;
	
	public UserController(CreateUserUseCase createUser, Converter convert) {
		super();
		this.createUser = createUser;
		this.convert = convert;
	}



	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addUser(@RequestBody RestUser restUser) {
		createUser.execute(convert.RestUserToDomain(restUser));
		return new ResponseEntity<Response>(new Response("Successfully Added"), HttpStatus.CREATED);
	}

}
