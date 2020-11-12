package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.gms.model.Complaint;


public class HeadDaoImpl implements IHeadDao {

	public List<Complaint> getComplaints() throws Exception {
		String sql = "select cid,userid,deptid,description,userremark,headremark,status,screenshot from complaint";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
        System.out.println(sql);
		List<Complaint> complaints = new ArrayList<Complaint>();
		while (rs.next()) {
			complaints.add(new Complaint(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getBytes(8)));
		}
		return complaints;
	}
	
	
	public int transferComplaint(int cid) throws Exception {
	Complaint complaint = new Complaint(); 
		String sql = "update complaint set deptid =? where cid = ?";
		Connection connection = DbUtil.getConnection();
		//System.out.println(user.getPassword());
		PreparedStatement ps = connection.prepareStatement(sql);
	    
		ps.setInt(1, complaint.getcId());
		ps.setInt(2, complaint.getDeptId());
		System.out.println(ps.executeUpdate());
		System.out.println("in transfer complaint()");
		
		return ps.executeUpdate(); 
	}
	public List<Complaint> getComplaints1() throws Exception {
		String sql = "select cid,userid,deptid,description,userremark,headremark,status,screenshot from complaint";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
        System.out.println(sql);
		List<Complaint> complaints = new ArrayList<Complaint>();
		while (rs.next()) {
			complaints.add(new Complaint(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getBytes(8)));
		}
		return complaints;
	}

}
