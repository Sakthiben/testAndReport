package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemWiseLevelBean {
	
	private int iwlId;
	
	@NotNull
	 @NotEmpty(message = "Please enter the item ")
	private String itemCode;
	
	@NotNull
	 @NotEmpty(message = "Please enter the description")
	private String description;
	
	@NotNull
	 @NotEmpty(message = "Please enter the safety stock")
	private String safetyStk;
	
	@NotNull
	 @NotEmpty(message = "Please enter the leading time days")
	private String leadtimeDays;
	
	@NotNull
	 @NotEmpty(message = "Please enter the consumed")
	private String consumed;
	
	@NotNull
	 @NotEmpty(message = "Please enter the delivered")
	private String delivered;
	
	@NotNull
	 @NotEmpty(message = "Please enter the total outgoing")
	private String totalOutgoing;
	
	@NotNull
	 @NotEmpty(message = "Please enter the average daily outgoing")
	private String avgdailyOutgoing;
	
	@NotNull
	 @NotEmpty(message = "Please enter the reorder level")
	private String reorderlevel;
	public int getIwlId() {
		return iwlId;
	}
	public void setIwlId(int iwlId) {
		this.iwlId = iwlId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSafetyStk() {
		return safetyStk;
	}
	public void setSafetyStk(String safetyStk) {
		this.safetyStk = safetyStk;
	}
	public String getLeadtimeDays() {
		return leadtimeDays;
	}
	public void setLeadtimeDays(String leadtimeDays) {
		this.leadtimeDays = leadtimeDays;
	}
	public String getConsumed() {
		return consumed;
	}
	public void setConsumed(String consumed) {
		this.consumed = consumed;
	}
	public String getDelivered() {
		return delivered;
	}
	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}
	public String getTotalOutgoing() {
		return totalOutgoing;
	}
	public void setTotalOutgoing(String totalOutgoing) {
		this.totalOutgoing = totalOutgoing;
	}
	public String getAvgdailyOutgoing() {
		return avgdailyOutgoing;
	}
	public void setAvgdailyOutgoing(String avgdailyOutgoing) {
		this.avgdailyOutgoing = avgdailyOutgoing;
	}
	public String getReorderlevel() {
		return reorderlevel;
	}
	public void setReorderlevel(String reorderlevel) {
		this.reorderlevel = reorderlevel;
	}
	
	

}
