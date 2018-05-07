package com.armadillo.api.security.model;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "roles")
public class Role {
   private Long id;
   public Long getId() {
	return id;
}
public void setId(Long id) {
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
public Collection<User> getUsers() {
	return users;
}
public void setUsers(Collection<User> users) {
	this.users = users;
}
private String name;
   private Collection<Privilege> privileges;   
   private Collection<User> users;
}
