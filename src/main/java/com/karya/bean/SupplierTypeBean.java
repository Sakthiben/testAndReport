package com.karya.bean;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class SupplierTypeBean {
	private int sutypeId;
        @NotNull
	@NotEmpty(message = "Please enter supName.")
	private String supName;
        @NotNull
        @NotEmpty(message = "Please enter suType.")
	private String suType;
	
	
	public int getSutypeId() {
		return sutypeId;
	}
	public void setSutypeId(int sutypeId) {
		this.sutypeId = sutypeId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSuType() {
		return suType;
	}
	public void setSuType(String suType) {
		this.suType = suType;
	}
	
	

}
