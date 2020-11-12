package com.gms.model;

public class Department {
	private int deptId;
	private String deptName;
	private int userId;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int deptId, String deptName, int userId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.userId = userId;
	}
	public Department(String deptName, int userId) {
		super();
		this.deptName = deptName;
		this.userId = userId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", userId=" + userId + "]";
	}
	
}
