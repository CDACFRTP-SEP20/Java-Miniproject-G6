package com.gms.model;


//class for displaying department heads purpose
public class DeptHead {
	
	//member variables
	private String username;
	private String email;
	private String phoneNo;
	private String address;
	private String deptName;
	
	//constructors
	public DeptHead() {
		super();
	}
	public DeptHead(String username, String email, String phoneNo, String address, String deptName) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.deptName = deptName;
	}
	
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	//toString method
	@Override
	public String toString() {
		return "DeptHead [username=" + username + ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", deptName=" + deptName + "]";
	}
}
