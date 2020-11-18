package com.gms.service;

import java.util.List;

import com.gms.dao.AdminDaoImpl;
import com.gms.dao.CitizenDaoImpl;
import com.gms.dao.HeadDaoImpl;
import com.gms.dao.ICitizenDao;
import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;
import com.gms.model.Users;

public class CitizenService {

	//instance of ICitizenDao interface
	ICitizenDao citizenDao = new CitizenDaoImpl();
	
	//function for registering complaint
	public int registerComplaint(Complaint complaint) throws Exception {
		return  citizenDao.registerComplaint(complaint);
		
	}
	
	//function for getting userId by username
	public int getId(String username) throws Exception {
		return citizenDao.getId(username);
	}
	
	//function for getting complaints of particular citizen
	public List<ComplaintObject> getComplaints(int id)  throws Exception{
		// TODO Auto-generated method stub
		return citizenDao.getComplaints(id);
	}
	
	//function for registering new citizen
	public int registerCitizen(Users user) throws Exception {
		return citizenDao.registerUser(user);
	}
	
}
