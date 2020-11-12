package com.gms.dao;

import java.util.List;

import com.gms.model.Complaint;
import com.gms.model.Users;

public interface ICitizenDao {
	public int registerComplaint(Complaint complaint) throws Exception;
	public int getId(String username)throws Exception;
	public List<Complaint> getComplaints(int id) throws Exception;
	public int registerUser(Users user)throws Exception;
}
