package com.example.infraestructure.persistence.impl;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.core.port.IdGeneratorService;

@Component
public class IdGeneratorServiceImpl implements IdGeneratorService {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}

}
