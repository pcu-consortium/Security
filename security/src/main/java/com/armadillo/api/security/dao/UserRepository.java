package com.armadillo.api.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.armadillo.api.security.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	  User findByEmail(String email);

	    @Override
	void delete(User user);
}
