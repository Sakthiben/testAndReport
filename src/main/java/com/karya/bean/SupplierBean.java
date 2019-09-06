package com.karya.bean;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class SupplierBean {
	
	private int supId;
	@NotNull
	@NotEmpty(message = "Please enter supName.")
	private String supName;
	@NotNull
	@NotEmpty(message = "Please enter addType.")
	private String addType;
	@NotNull
	@NotEmpty(message = "Please enter supCity.")
	private String supCity;
	@NotNull
	@NotEmpty(message = "Please enter supAddress.")
	private String supAddress;
	@NotNull
	@NotEmpty(message = "Please enter supPhone.")
	private String supPhone;
	@NotNull
	@NotEmpty(message = "Please enter supCountry.")
	private String supCountry;
	@NotNull
	@NotEmpty(message = "Please enter supState.")
	private String supState;
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getAddType() {
		return addType;
	}
	public void setAddType(String addType) {
		this.addType = addType;
	}
	public String getSupCity() {
		return supCity;
	}
	public void setSupCity(String supCity) {
		this.supCity = supCity;
	}
	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	public String getSupPhone() {
		return supPhone;
	}
	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}
	public String getSupCountry() {
		return supCountry;
	}
	public void setSupCountry(String supCountry) {
		this.supCountry = supCountry;
	}
	public String getSupState() {
		return supState;
	}
	public void setSupState(String supState) {
		this.supState = supState;
	}
	
	

}
