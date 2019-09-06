package com.karya.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CustomerDetailsBean {
	
	private Integer id;
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String customerid;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customername.")
	private String customername;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customergroup.")
	private String customergroup;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String addressline1;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String addressline2;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String city;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String state;
	@NotNull
	@Size(min=1,max=10,message = "Please enter customerid.")
	private String postalcode;
	
	@NotNull
	@Size(min=1,max=50,message = "Please enter customerid.")
	private String country;
	
	//@NotNull
	@AssertTrue
	//@NotEmpty(message = "Please enter isprimaryaddress.")
	private Boolean isprimaryaddress;
	
	
	@NotEmpty(message = "Please enter firstname.")
	private String firstname;
	
	@NotNull
	@NotEmpty(message = "Please enter lastname.")
	private String lastname;
	
	
	@NotNull
	@Size(min=10,message="Phone number is not valid")
	private String phone;
	
	@NotNull
	@Size(min=10,message="Phone number is not valid")
	private String mobilenumber;
	
	@NotNull
	@Email
	@NotEmpty(message = "Please enter valid emailid.")
	private String emailid;
	
	//@NotNull
	@AssertTrue
	//@NotEmpty(message = "Please enter isprimarycontact.")
	private Boolean isprimarycontact;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomergroup() {
		return customergroup;
	}
	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Boolean getIsprimaryaddress() {
		return isprimaryaddress;
	}
	public void setIsprimaryaddress(Boolean isprimaryaddress) {
		this.isprimaryaddress = isprimaryaddress;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Boolean getIsprimarycontact() {
		return isprimarycontact;
	}
	public void setIsprimarycontact(Boolean isprimarycontact) {
		this.isprimarycontact = isprimarycontact;
	}	
}
