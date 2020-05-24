package com.example.infraestructure.converter.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.core.domain.User;
import com.example.infraestructure.controller.rest.RestUser;
import com.example.infraestructure.converter.Converter;

@Component
public class ConverterImpl implements Converter{
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public User RestUserToDomain(RestUser restUser) {
		User userDto = mapper.map(restUser, User.class);
		return userDto;
	}

}
