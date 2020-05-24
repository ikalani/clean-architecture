package com.example.infraestructure.persistence.impl;

import org.springframework.stereotype.Component;

import com.example.core.domain.User;
import com.example.core.port.IdGeneratorService;
import com.example.core.port.UserRepositoryService;
import com.example.infraestructure.persistence.entity.UserEntity;
import com.example.infraestructure.persistence.repository.UserRepository;

@Component
public class UserServiceImpl implements UserRepositoryService {

	private final UserRepository repository;
	private final UserEntity userToSave;
	private final IdGeneratorService idGenarator;

	public UserServiceImpl(UserRepository repository, UserEntity userToSave, IdGeneratorService idGenarator) {
		super();
		this.repository = repository;
		this.userToSave = userToSave;
		this.idGenarator = idGenarator;
	}

	@Override
	public void create(User user) {
		userToSave.setId(idGenarator.generate());
		userToSave.setEmail(user.getEmail());
		userToSave.setFirstName(user.getFirstName());
		userToSave.setLastName(user.getLastName());
		repository.save(userToSave);

	}

}
