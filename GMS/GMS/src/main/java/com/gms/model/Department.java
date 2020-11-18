package com.gms.model;

//POJO class
public class Department {
	
	//member variables
	private int deptId;
	private String deptName;
	private int userId;
	
	//constructors
	public Department() {
		super();
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
	
	//getters and setters
	public int getDeptId() {
		return deptId;
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
	
	//toString method
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", userId=" + userId + "]";
	}
	
}
