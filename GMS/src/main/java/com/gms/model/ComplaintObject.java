package com.gms.model;

import java.util.Arrays;

//ComplaintObject class for displaying complaits purpose
public class ComplaintObject {
	
	//member variables
	private int cId;
	private String username;
	private String deptName;
	private String description;
	private String userRemark;
	private String headRemark;
	private String status;
	private byte[] screenshot;
	
	//constructors
	public ComplaintObject() {
		super();
	}
	public ComplaintObject(int cId, String username, String deptName, String description, String userRemark,
			String headRemark, String status, byte[] screenshot) {
		super();
		this.cId = cId;
		this.username = username;
		this.deptName = deptName;
		this.description = description;
		this.userRemark = userRemark;
		this.headRemark = headRemark;
		this.status = status;
		this.screenshot = screenshot;
	}
	//getters and setters
	public int getcId() {
		return cId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	public String getHeadRemark() {
		return headRemark;
	}
	public void setHeadRemark(String headRemark) {
		this.headRemark = headRemark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(byte[] screenshot) {
		this.screenshot = screenshot;
	}
	
	//toString method
	@Override
	public String toString() {
		return "ComplaintObject [cId=" + cId + ", username=" + username + ", deptName=" + deptName + ", description="
				+ description + ", userRemark=" + userRemark + ", headRemark=" + headRemark + ", status=" + status
				+ ", screenshot=" + Arrays.toString(screenshot) + "]";
	}
	
	
}
