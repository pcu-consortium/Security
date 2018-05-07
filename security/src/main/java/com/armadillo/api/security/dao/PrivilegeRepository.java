package com.armadillo.api.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.armadillo.api.security.model.Privilege;


public interface PrivilegeRepository  extends MongoRepository<Privilege, String>{

    Privilege findByName(String name);

    @Override
void delete(Privilege privilege);
	
	
	
}
