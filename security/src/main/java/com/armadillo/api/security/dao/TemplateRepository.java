package com.armadillo.api.security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.armadillo.api.security.model.Template;
import com.armadillo.api.security.model.User;

@Repository
public interface TemplateRepository  extends MongoRepository<Template, String>{ 
	Template findByName(String name);
	  @Override
  	void delete(Template t);
	
}


