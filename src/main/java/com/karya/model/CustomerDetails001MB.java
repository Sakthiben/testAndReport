package com.karya.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;	

@Entity
@Table(name="customerdetails001mb")
public class CustomerDetails001MB  {
	

	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "id")
private Integer id;

@Column(name="customerid")
private String customerid;

@Column(name="customername")
private String customername;

@Column(name="customergroup")
private String customergroup;

@Column(name="addressline1")
private String addressline1;	

@Column(name="addressline2")
private String addressline2;

@Column(name="city")
private String city;

@Column(name="state")
private String state;	

@Column(name="postalcode")
private String postalcode;

@Column(name="country")
private String country;

@Column(name="isprimaryaddress")
private Boolean isprimaryaddress;	

@Column(name="firstname")
private String firstname;

@Column(name="lastname")
private String lastname;

@Column(name="phone")
private String phone;	

@Column(name="mobilenumber")
private String mobilenumber;

@Column(name="emailid")
private String emailid;

@Column(name="isprimarycontact")
private Boolean isprimarycontact;

@OneToMany(mappedBy="customerdetails001MB")
private Set<CustomerCreditBalance001MB> customercreditbalance001MB;

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

public Set<CustomerCreditBalance001MB> getCustomercreditbalance001MB() {
	return customercreditbalance001MB;
}

public void setCustomercreditbalance001MB(Set<CustomerCreditBalance001MB> customercreditbalance001mb) {
	customercreditbalance001MB = customercreditbalance001mb;
}



}
