package com.gms.model;

import java.sql.Blob;
import java.util.Arrays;

public class Complaint {
	private int cId;
	private int userId;
	private int deptId;
	private String description;
	private String userRemark;
	private String headRemark;
	private String status;
	private byte[] screenshot;
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(int cId, int userId, int deptId, String description, String userRemark, String headRemark,
			String status, byte[] screenshot) {
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
			byte[] screenshot) {
		super();
		this.userId = userId;
		this.deptId = deptId;
		this.description = description;
		this.userRemark = userRemark;
		this.headRemark = headRemark;
		this.status = status;
		this.screenshot = screenshot;
	}
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
	public byte[] getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(byte[] screenshot) {
		this.screenshot = screenshot;
	}
	@Override
	public String toString() {
		return "Complaint [cId=" + cId + ", userId=" + userId + ", deptId=" + deptId + ", description=" + description
				+ ", userRemark=" + userRemark + ", headRemark=" + headRemark + ", status=" + status + ", screenshot="
				+ Arrays.toString(screenshot) + "]";
	}
	
}
