package com.example.infraestructure.persistence.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.core.port.IdGeneratorService;

@Service
public class IdGeneratorServiceImpl implements IdGeneratorService {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}

}
