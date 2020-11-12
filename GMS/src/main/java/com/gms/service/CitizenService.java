package com.gms.service;

import java.util.List;

import com.gms.dao.AdminDaoImpl;
import com.gms.dao.CitizenDaoImpl;
import com.gms.dao.HeadDaoImpl;
import com.gms.dao.ICitizenDao;
import com.gms.model.Complaint;
import com.gms.model.Users;

public class CitizenService {

	CitizenDaoImpl citizenDao = new CitizenDaoImpl();
	public int registerComplaint(Complaint complaint) throws Exception {
		return  citizenDao.registerComplaint(complaint);
		
	}
	public int getId(String username) throws Exception {
		return citizenDao.getId(username);
	}
	public List<Complaint> getComplaints(int id)  throws Exception{
		// TODO Auto-generated method stub
		return citizenDao.getComplaints(id);
	}
	public int registerCitizen(Users user) throws Exception {
		return citizenDao.registerUser(user);
	}
	
}
