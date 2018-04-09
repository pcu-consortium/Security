package com.armadillo.api.security;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/ldap")

public class PersonController {
	
	@Autowired
	PersonRepository persons;
	
	
	@RequestMapping(value = "persons", method = RequestMethod.GET)
	public ResponseEntity getNames() {
		List<String> names = persons.getPersonNames();
		
		if(names== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(names,HttpStatus.OK);
		}
		
	
	}
	
	

}
	
	
	
	
	
	
	
	
	
	


