package com.findat.model;

import java.util.concurrent.atomic.AtomicLong;

public class User {
	private long id;
	private String username;
    private String name;
    private String lastName;
    private String nif;
    private String email;
    private static final AtomicLong counter = new AtomicLong(100);

    public User(String username, String name, String lastName, String nif, String email, long id) {
        this.username = username;
    	this.name = name;
        this.lastName = lastName;
        this.nif = nif;
        this.email = email;            
        this.id = id;
    }
    
    public User(String username, String name, String lastName, String nif, String email) {
    	this.username = username;
    	this.name = name;
        this.lastName = lastName;
        this.nif = nif;
        this.email = email;      
        this.id = counter.incrementAndGet();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static AtomicLong getCounter() {
		return counter;
	}  
}