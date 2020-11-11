package com.gms.dao;

import java.util.List;

import com.gms.model.Complaint;

public interface IHeadDao {
	public List<Complaint> getComplaints() throws Exception;
}
