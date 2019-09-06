package com.karya.bean;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class SupplierStatusBean {
	private int sustatusId;
	@NotNull
	@NotEmpty(message = "Please select supName.")
	private String supName;
    @NotNull
	@NotEmpty(message = "Please select sustatus.")
	private String sustatus;
	@NotNull
	@NotEmpty(message = "Please enter phone number.")
	/*@Size(min=10,message="Phone number is not valid")
	*/private String phone;

	public int getSustatusId() {
		return sustatusId;
	}
	public void setSustatusId(int sustatusId) {
		this.sustatusId = sustatusId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSustatus() {
		return sustatus;
	}
	public void setSustatus(String sustatus) {
		this.sustatus = sustatus;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
