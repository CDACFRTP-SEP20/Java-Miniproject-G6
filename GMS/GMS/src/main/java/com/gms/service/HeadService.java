package com.gms.service;

import java.util.List;


import com.gms.dao.HeadDaoImpl;
import com.gms.model.Complaint;

public class HeadService {

	HeadDaoImpl headDao = new HeadDaoImpl();
	public List<Complaint> getComplaints()throws Exception {
		return headDao.getComplaints();
	}

}
