package com.tiger.designPatterns200.model.user;

public class RegistrationDTO {

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String passwordRepeated;
	

	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordRepeated() {
		return passwordRepeated;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}
	
	
	
	
	
}
