package com.example.infraestructure.persistence.impl;

import org.springframework.stereotype.Component;

import com.example.core.domain.User;
import com.example.core.port.UserRepositoryService;
import com.example.infraestructure.converter.Converter;
import com.example.infraestructure.persistence.repository.UserRepository;

@Component
public class UserServiceImpl implements UserRepositoryService {

	private final UserRepository repository;
	private final Converter convert;

	public UserServiceImpl(UserRepository repository, Converter convert) {
		super();
		this.repository = repository;
		this.convert = convert;
	}

	@Override
	public void create(User user) {
		repository.save(convert.UserToUserEntity(user));

	}

}
