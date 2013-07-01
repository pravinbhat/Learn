package com.pravin.learn.spring.hellomvcdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6215675444789108363L;
	
	@Id
	private String id;
	private String name;

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