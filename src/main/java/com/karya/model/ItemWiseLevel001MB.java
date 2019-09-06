package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemwiselevel001mb")
public class ItemWiseLevel001MB implements Serializable{
	private static final long serialVersionUID = -723583058586873479L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "iwlId")
	private int iwlId;
	
	@Column(name="itemCode")
	private String itemCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="safetyStk")
	private String safetyStk;
	
	@Column(name="leadtimeDays")
	private String leadtimeDays;
	
	
	@Column(name="consumed")
	private String consumed;
	
	@Column(name="delivered")
	private String delivered;
	
	@Column(name="totalOutgoing")
	private String totalOutgoing;
	
	@Column(name="avgdailyOutgoing")
	private String avgdailyOutgoing;
	
	@Column(name="reorderlevel")
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
