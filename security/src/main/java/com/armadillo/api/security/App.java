package com.armadillo.api.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.armadillo.api.security","com.armadillo.api.security.client"})
public class App 
{
	   public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	}
}


