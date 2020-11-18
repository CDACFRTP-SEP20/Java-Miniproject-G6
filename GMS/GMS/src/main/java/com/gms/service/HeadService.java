package com.gms.service;

import java.util.List;

import com.gms.dao.HeadDaoImpl;
import com.gms.dao.IHeadDao;
import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;

public class HeadService {

	// instance of IHeadDao interface
	IHeadDao headDao = new HeadDaoImpl();

	// function for getting all pending complaints by headName
	public List<ComplaintObject> getComplaints(String headName) throws Exception {
		return headDao.getComplaints(headName);
	}

	// function for getting all resolved complaints by headName
	public List<ComplaintObject> getResolvedComplaints(String headName) throws Exception {
		return headDao.getResolvedComplaints(headName);
	}

	// function to transfer complaint to another department
	public int transferComplaint(int cid) throws Exception {
		return cid;
	}

	// function for getting deptId by department name
	public int getDeptIdByDeptName(String parameter) throws Exception {
		// TODO Auto-generated method stub
		return headDao.getDeptId(parameter);
	}

	// function for updating deptId after transfer complaint to another department
	public int updateDeptId(int id, int cid) throws Exception {
		// TODO Auto-generated method stub
		return headDao.updateDeptId(id, cid);
	}

	// function for taking action on complaint
	public int takeAction(int cid) throws Exception {
		return headDao.takeAction(cid);

	}

}
