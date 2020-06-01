package com.example.infraestructure.converter.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.core.domain.User;
import com.example.core.port.IdGeneratorService;
import com.example.infraestructure.controller.rest.RestUser;
import com.example.infraestructure.converter.Converter;
import com.example.infraestructure.persistence.entity.UserEntity;

@Component
public class ConverterImpl implements Converter{
	
	ModelMapper mapper = new ModelMapper();
	
	private final IdGeneratorService idGenarator;
	
	public ConverterImpl(IdGeneratorService idGenarator) {
		super();
		this.idGenarator = idGenarator;
	}

	@Override
	public User RestUserToDomain(RestUser restUser) {
		User user = mapper.map(restUser, User.class);
		return user;
	}

	@Override
	public UserEntity UserToUserEntity(User user) {
		 UserEntity entityUser= mapper.map(user, UserEntity.class);
		 entityUser.setId(idGenarator.generate());
		return entityUser;
	}

}
