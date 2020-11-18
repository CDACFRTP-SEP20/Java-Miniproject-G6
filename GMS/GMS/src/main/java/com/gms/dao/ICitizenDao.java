package com.gms.dao;

import java.util.List;

import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;
import com.gms.model.Users;

public interface ICitizenDao {
	
	//function for registering complaint
	public int registerComplaint(Complaint complaint) throws Exception;
	
	//function for getting userId by username
	public int getId(String username)throws Exception;
	
	//function for getting complaints of particular citizen
	public List<ComplaintObject> getComplaints(int id) throws Exception;
	
	//function for registering new citizen
	public int registerUser(Users user)throws Exception;
}
