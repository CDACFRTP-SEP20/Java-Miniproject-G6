package com.gms.service;

import com.gms.dao.AdminDaoImpl;
import com.gms.dao.CitizenDaoImpl;
import com.gms.dao.ICitizenDao;
import com.gms.model.Complaint;

public class CitizenService {

	CitizenDaoImpl citizenDao = new CitizenDaoImpl();
	public int registerComplaint(Complaint complaint) throws Exception {
		return  citizenDao.registerComplaint(complaint);
		
	}
	public int getId(String username) throws Exception {
		return citizenDao.getId(username);
	}
}
