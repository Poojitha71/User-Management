package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}