package com.example.infraestructure.converter;

import com.example.core.domain.User;
import com.example.infraestructure.controller.rest.RestUser;

public interface Converter {
	
	public User RestUserToDomain(RestUser restUser);

}
