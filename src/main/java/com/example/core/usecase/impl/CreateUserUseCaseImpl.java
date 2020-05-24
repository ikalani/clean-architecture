package com.example.core.usecase.impl;

import org.springframework.stereotype.Component;

import com.example.core.domain.User;
import com.example.core.port.UserRepositoryService;
import com.example.core.usecase.CreateUserUseCase;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
	
	private  final UserRepositoryService userRepository;
	
	public CreateUserUseCaseImpl(UserRepositoryService userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public void execute(User user) {
	
		userRepository.create(user);
		
	}

	
}
