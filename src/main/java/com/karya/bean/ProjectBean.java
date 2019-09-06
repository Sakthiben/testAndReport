package com.karya.bean;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectBean {
	
 private int id;
 @NotNull
	@NotEmpty(message = "Please enter project name.") 
 
 private String projectname;
 
 @Min(value=1)
 @NotNull(message= "Please enter estimatedcost")
 private int estimatedcost;

 @NotNull
 @NotEmpty(message = "Please enter the start date.")
 private String startdate;

 @NotNull
 @NotEmpty(message = "Please enter the End date.")
 private String enddate;
 @NotNull
	@NotEmpty(message = "Please enter status.") 
 
 private String status;
 
public int getId() {
	return id;
}
public String getStartdate() {
	return startdate;
}
public void setStartdate(String startdate) {
	this.startdate = startdate;
}
public String getEnddate() {
	return enddate;
}
public void setEnddate(String enddate) {
	this.enddate = enddate;
}
public void setId(int id) {
	this.id = id;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getProjectname() {
	return projectname;
}
public void setProjectname(String projectname) {
	this.projectname = projectname;
}
public int getEstimatedcost() {
	return estimatedcost;
}
public void setEstimatedcost(int estimatedcost) {
	this.estimatedcost = estimatedcost;
}


 
}