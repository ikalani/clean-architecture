package com.example.infraestructure.converter;

import com.example.core.domain.User;
import com.example.infraestructure.controller.rest.RestUser;
import com.example.infraestructure.persistence.entity.UserEntity;

public interface Converter {
	
	public User RestUserToDomain(RestUser restUser);
	
	public UserEntity UserToUserEntity(User user);

}
