package com.armadillo.api.security.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.armadillo.api.security.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	  User findByEmail(String email);
	  List<User> findBylastName(String lastName);
 	    @Override
    	void delete(User user);
}
