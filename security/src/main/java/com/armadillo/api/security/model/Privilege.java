package com.armadillo.api.security.model;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privilege")
public class Privilege {
	
	@Id
	public String id;
	public Collection<Template> getTemplates() {
		return templates;
	}
	public void setTemplates(Collection<Template> templates) {
		this.templates = templates;
	}
	private String name;
	private Collection<Template> templates;  
	
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
	
}
