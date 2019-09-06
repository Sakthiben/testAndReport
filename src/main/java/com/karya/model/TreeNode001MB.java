package com.karya.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treenode001mb")
public class TreeNode001MB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private Long id;
	
	@Column(name="PARENTNAME", nullable = false)
	private String parentName;
	//private boolean isParent;
	
	@Column(name="ISPARENT", nullable = false)
	private String isParent;
	
	@Column(name="PID", nullable = false)
	private String pId;
	
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	//private int pId;
	
	/*public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	//public boolean isParent() {
		//return isParent;
	//}
	//public void setParent(boolean isParent) {
		//this.isParent = isParent;
	//}
	
	

}
