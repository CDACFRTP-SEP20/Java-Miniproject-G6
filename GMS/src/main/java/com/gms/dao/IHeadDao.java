package com.gms.dao;

import java.sql.SQLException;
import java.util.List;

import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;

public interface IHeadDao {
	
	//function for getting all pending complaints by headName
	public List<ComplaintObject> getComplaints(String headName) throws Exception;
	
	//function for getting all resolved complaints by headName
	public List<ComplaintObject> getResolvedComplaints(String headName) throws Exception;
	
	//function for getting deptId by headName
	public int getDeptId(String headName) throws Exception;
	
	//function for getting deptId by department name
	public int getDeptIdByDeptName(String deptname)throws Exception;
	
	//function for updating deptId after transfer complaint to another department
	public int updateDeptId(int id,int cid) throws SQLException, Exception;
	
	//function for taking action on complaint
	public int takeAction(int cid) throws Exception;

}
