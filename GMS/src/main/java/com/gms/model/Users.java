package com.gms.model;

public class Users {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String phoneNo;
	private String address;
	private String role;
	private int deptId;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String username, String password, String email, String phoneNo, String address,
			String role, int deptId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.role = role;
		this.deptId = deptId;
	}
	public Users(String username, String password, String email, String phoneNo, String address, String role,
			int deptId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.role = role;
		this.deptId = deptId;
	}
	public Users(String username, String password, String email, String phoneNo, String address, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", address=" + address + ", role=" + role + ", deptId=" + deptId + "]";
	}
	
}
