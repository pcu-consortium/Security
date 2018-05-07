package com.armadillo.api.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.armadillo.api.security.model.Role;


public interface RoleRepository extends MongoRepository<Role, String>{
	   Role findByName(String name);

	    @Override
    	void delete(Role role);
}
