package com.karya.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationBean {
	
	private int id;
	
	@NotNull
	@NotEmpty(message = "Please enter your Firstname.")
	@Size(min = 6, max = 30, message = "Your firstname must between 6 to 30 characters")
	private String firstname;
	
	@NotNull
	@NotEmpty(message = "Please enter your Lastname.")
	@Size(min = 6, max = 30, message = "Your lastname must between 6 to 30 characters")
	private String lastname;
	
	@NotNull
	@NotEmpty(message = "Please enter your Domain.")
	private String domain;
	
	private String username;
	
	private String password;
		
	private boolean enabled;
	
	@NotNull
	@NotEmpty(message = "Please select your Security Question.")
	private String securityquestion;
	
	@NotNull
	@NotEmpty(message = "Please enter your Security Answer.")
	@Size(min = 6, max = 30, message = "Your securityanswer must between 6 and 15 characters")
	private String securityanswer;
	
	@NotNull
	@NotEmpty(message = "Please select your Security Question.")
	private String newusername;
	
	private String newpassword;
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	private String message;
		   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getSecurityquestion() {
		return securityquestion;
	}
	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}
	public String getSecurityanswer() {
		return securityanswer;
	}
	public String getNewusername() {
		return newusername;
	}
	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}
	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	   
	
	
	
}	