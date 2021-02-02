package com.springtest.firstbase.domain;

import javax.persistence.*;
@Entity
public class FBEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String name;
    public String email;
    public String title;
    
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	
}
