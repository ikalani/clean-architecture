package com.example.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.infraestructure.persistence.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
