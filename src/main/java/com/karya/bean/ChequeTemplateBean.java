package com.karya.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ChequeTemplateBean {
	
	
	private int  cheqId;
	
	@NotNull
	@NotEmpty(message = "Please enter account name")
	private String  prmaccountName;
	
	private boolean prmisaccPay;
	private String prmcheqSize;
	private String prmdistfromTop;
	private String prmcheqWidth;
	private String prmdistfromLeft;
	private String prmcheqHeight;
	
	@NotNull
	@NotEmpty(message = "Please enter message to show")
	private String prmmesgtoShow;
	private String scanCheq;
	private String dtdistfromTop;
	private String dtdistfromLeft;
	private String paydistfromTop;
	private String paydistfromLeft;
	private String amtwdistfromTop;
	private String amtwdistfromLeft;
	private String amtwWidth;
	private String amtwlineSpace;
	private String amtfdistfromTop;
	private String amtfdistfromLeft;
	private String accnodistfromTop;
	private String accnodistfromLeft;
	private String signposdistfromTop;
	private String signposdistfromLeft;
	public int getCheqId() {
		return cheqId;
	}
	public void setCheqId(int cheqId) {
		this.cheqId = cheqId;
	}
	public String getPrmaccountName() {
		return prmaccountName;
	}
	public void setPrmaccountName(String prmaccountName) {
		this.prmaccountName = prmaccountName;
	}
	public boolean isPrmisaccPay() {
		return prmisaccPay;
	}
	public void setPrmisaccPay(boolean prmisaccPay) {
		this.prmisaccPay = prmisaccPay;
	}
	public String getPrmcheqSize() {
		return prmcheqSize;
	}
	public void setPrmcheqSize(String prmcheqSize) {
		this.prmcheqSize = prmcheqSize;
	}
	public String getPrmdistfromTop() {
		return prmdistfromTop;
	}
	public void setPrmdistfromTop(String prmdistfromTop) {
		this.prmdistfromTop = prmdistfromTop;
	}
	public String getPrmcheqWidth() {
		return prmcheqWidth;
	}
	public void setPrmcheqWidth(String prmcheqWidth) {
		this.prmcheqWidth = prmcheqWidth;
	}
	public String getPrmdistfromLeft() {
		return prmdistfromLeft;
	}
	public void setPrmdistfromLeft(String prmdistfromLeft) {
		this.prmdistfromLeft = prmdistfromLeft;
	}
	public String getPrmcheqHeight() {
		return prmcheqHeight;
	}
	public void setPrmcheqHeight(String prmcheqHeight) {
		this.prmcheqHeight = prmcheqHeight;
	}
	public String getPrmmesgtoShow() {
		return prmmesgtoShow;
	}
	public void setPrmmesgtoShow(String prmmesgtoShow) {
		this.prmmesgtoShow = prmmesgtoShow;
	}
	public String getScanCheq() {
		return scanCheq;
	}
	public void setScanCheq(String scanCheq) {
		this.scanCheq = scanCheq;
	}
	public String getDtdistfromTop() {
		return dtdistfromTop;
	}
	public void setDtdistfromTop(String dtdistfromTop) {
		this.dtdistfromTop = dtdistfromTop;
	}
	public String getDtdistfromLeft() {
		return dtdistfromLeft;
	}
	public void setDtdistfromLeft(String dtdistfromLeft) {
		this.dtdistfromLeft = dtdistfromLeft;
	}
	public String getPaydistfromTop() {
		return paydistfromTop;
	}
	public void setPaydistfromTop(String paydistfromTop) {
		this.paydistfromTop = paydistfromTop;
	}
	public String getPaydistfromLeft() {
		return paydistfromLeft;
	}
	public void setPaydistfromLeft(String paydistfromLeft) {
		this.paydistfromLeft = paydistfromLeft;
	}
	public String getAmtwdistfromTop() {
		return amtwdistfromTop;
	}
	public void setAmtwdistfromTop(String amtwdistfromTop) {
		this.amtwdistfromTop = amtwdistfromTop;
	}
	public String getAmtwdistfromLeft() {
		return amtwdistfromLeft;
	}
	public void setAmtwdistfromLeft(String amtwdistfromLeft) {
		this.amtwdistfromLeft = amtwdistfromLeft;
	}
	public String getAmtwWidth() {
		return amtwWidth;
	}
	public void setAmtwWidth(String amtwWidth) {
		this.amtwWidth = amtwWidth;
	}
	public String getAmtwlineSpace() {
		return amtwlineSpace;
	}
	public void setAmtwlineSpace(String amtwlineSpace) {
		this.amtwlineSpace = amtwlineSpace;
	}
	public String getAmtfdistfromTop() {
		return amtfdistfromTop;
	}
	public void setAmtfdistfromTop(String amtfdistfromTop) {
		this.amtfdistfromTop = amtfdistfromTop;
	}
	public String getAmtfdistfromLeft() {
		return amtfdistfromLeft;
	}
	public void setAmtfdistfromLeft(String amtfdistfromLeft) {
		this.amtfdistfromLeft = amtfdistfromLeft;
	}
	public String getAccnodistfromTop() {
		return accnodistfromTop;
	}
	public void setAccnodistfromTop(String accnodistfromTop) {
		this.accnodistfromTop = accnodistfromTop;
	}
	public String getAccnodistfromLeft() {
		return accnodistfromLeft;
	}
	public void setAccnodistfromLeft(String accnodistfromLeft) {
		this.accnodistfromLeft = accnodistfromLeft;
	}
	public String getSignposdistfromTop() {
		return signposdistfromTop;
	}
	public void setSignposdistfromTop(String signposdistfromTop) {
		this.signposdistfromTop = signposdistfromTop;
	}
	public String getSignposdistfromLeft() {
		return signposdistfromLeft;
	}
	public void setSignposdistfromLeft(String signposdistfromLeft) {
		this.signposdistfromLeft = signposdistfromLeft;
	}
	
	
	
	
	
	
	
}
