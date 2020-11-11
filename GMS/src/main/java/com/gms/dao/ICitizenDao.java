package com.gms.dao;

import com.gms.model.Complaint;

public interface ICitizenDao {
	public int registerComplaint(Complaint complaint) throws Exception;
	public int getId(String username)throws Exception;
}
