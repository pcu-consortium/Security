package com.armadillo.api.security.model;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "role")
public class Role {
	@Id
   private String id;
   public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Collection<Privilege> getPrivileges() {
	return privileges;
}
public void setPrivileges(Collection<Privilege> privileges) {
	this.privileges = privileges;
}

private String name;
   private Collection<Privilege> privileges;   
   
}
