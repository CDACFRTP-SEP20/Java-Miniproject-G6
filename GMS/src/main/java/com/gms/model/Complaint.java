package com.gms.model;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Arrays;

//POJO class
public class Complaint {
	
	//member variables
	private int cId;
	private int userId;
	private int deptId;
	private String description;
	private String userRemark;
	private String headRemark;
	private String status;
	private InputStream screenshot;
	
	//constructors
	public Complaint() {
		super();
	}
	public Complaint(int cId, int userId, int deptId, String description, String userRemark, String headRemark,
			String status, InputStream screenshot) {
		super();
		this.cId = cId;
		this.userId = userId;
		this.deptId = deptId;
		this.description = description;
		this.userRemark = userRemark;
		this.headRemark = headRemark;
		this.status = status;
		this.screenshot = screenshot;
	}
	public Complaint(int userId, int deptId, String description, String userRemark, String headRemark, String status,
			InputStream screenshot) {
		super();
		this.userId = userId;
		this.deptId = deptId;
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
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	public InputStream getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(InputStream screenshot) {
		this.screenshot = screenshot;
	}
	@Override
	public String toString() {
		return "Complaint [cId=" + cId + ", userId=" + userId + ", deptId=" + deptId + ", description=" + description
				+ ", userRemark=" + userRemark + ", headRemark=" + headRemark + ", status=" + status + ", screenshot="
				+ screenshot + "]";
	}
	
	//toString method

	
}
