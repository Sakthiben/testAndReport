package com.karya.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chequetemplate001mb")
public class ChequeTemplate001MB implements Serializable{
	
private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cheqId")
	private int cheqId;
	
	
	@Column(name="prmaccountName")
	private String  prmaccountName;
	
	@Column(name="prmisaccPay")
	private boolean prmisaccPay;
	
	@Column(name="prmcheqSize")
	private String  prmcheqSize;
	
	@Column(name="prmdistfromTop")
	private String prmdistfromTop;
	@Column(name="prmcheqWidth")
	private String  prmcheqWidth;
	
	@Column(name="prmdistfromLeft")
	private String prmdistfromLeft;
	@Column(name="prmcheqHeight")
	private String  prmcheqHeight;
	
	@Column(name="prmmesgtoShow")
	private String prmmesgtoShow;
	@Column(name="scanCheq")
	private String  scanCheq;
	
	@Column(name="dtdistfromTop")
	private String dtdistfromTop;
	@Column(name="dtdistfromLeft")
	private String  dtdistfromLeft;
	
	@Column(name="paydistfromTop")
	private String paydistfromTop;
	@Column(name="paydistfromLeft")
	private String  paydistfromLeft;
	
	@Column(name="amtwdistfromTop")
	private String amtwdistfromTop;
	@Column(name="amtwdistfromLeft")
	private String  amtwdistfromLeft;
	
	@Column(name="amtwWidth")
	private String amtwWidth;
	@Column(name="amtwlineSpace")
	private String  amtwlineSpace;
	
	@Column(name="amtfdistfromTop")
	private String amtfdistfromTop;
	@Column(name="amtfdistfromLeft")
	private String  amtfdistfromLeft;
	
	@Column(name="accnodistfromTop")
	private String accnodistfromTop;
	@Column(name="accnodistfromLeft")
	private String  accnodistfromLeft;
	
	@Column(name="signposdistfromTop")
	private String signposdistfromTop;
	@Column(name="signposdistfromLeft")
	private String  signposdistfromLeft;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
