package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;

public class HeadDaoImpl implements IHeadDao {
	public static final Logger logger = LogManager.getLogger(HeadDaoImpl.class.getName());
	//function for getting all pending complaints by headName
	public List<ComplaintObject> getComplaints(String headName) throws Exception {
		String sql = "select c.cid,u.username,d.deptname,c.description,c.userremark,c.headremark,c.status,c.screenshot from complaint c join users u on c.userId=u.userId join department d on c.deptId=d.deptId where c.deptid=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		int deptId=getDeptId(headName);
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		List<ComplaintObject> complaints = new ArrayList<ComplaintObject>();
		while (rs.next()) {
			//for pending complaints
			if (rs.getString("status").equals("pending")) {
				complaints.add(new ComplaintObject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getBytes(8)));
			}
		}
		logger.info("Admin Adding head into the Database");
		return complaints;
	}
	
	//function for getting all resolved complaints by headName
	public List<ComplaintObject> getResolvedComplaints(String headName) throws Exception {
		String sql = "select c.cid,u.username,d.deptname,c.description,c.userremark,c.headremark,c.status,c.screenshot from complaint c join users u on c.userId=u.userId join department d on c.deptId=d.deptId where c.deptid=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		int deptId=getDeptId(headName);
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		List<ComplaintObject> resolvedcomplaints = new ArrayList<ComplaintObject>();
		while (rs.next()) {
			//for resolved complaints
			if (rs.getString("status").equals("resolved")) {
				resolvedcomplaints.add(new ComplaintObject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getBytes(8)));
			}
		}
		logger.info("Getting all resolved complaints by Headname");
		return resolvedcomplaints;
	}

	//function for getting deptId by headName
	public int getDeptId(String headName) throws Exception {
		String sql = "select deptid from users where username=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, headName);
		ResultSet rs = ps.executeQuery();
		int deptId = 0;
		while (rs.next()) {
			deptId = rs.getInt(1);
		}
		logger.info("Getting Department id of that head");
		return deptId;
	}
	
	//function for getting deptId by deptName which is needed for transfer complaint to another department
	public int getDeptIdByDeptName(String deptName) throws Exception {
		String sql="select deptid from department where deptname=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, deptName);
		ResultSet rs=ps.executeQuery();
		int id=0;
		while (rs.next()) {
			id=rs.getInt("deptid");
			System.out.println("dept id in dao"+id);
		}
		logger.info("getting deptId by deptName which is needed for transfer complaint to another department from database");
		return id;
	}

	//function for updating deptId after transfer complaint to another department
	public int updateDeptId(int deptId,int cId) throws Exception {
		String sql = "update complaint set deptid = ? where cid = ?";
		Connection connection = DbUtil.getConnection();
	    PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,deptId);
		ps.setInt(2,cId);
		logger.info("updating department id after transfer complaint to another department");
		return ps.executeUpdate();
	}

	//function for taking action on complaint
	public int takeAction(int cId) throws Exception {
		String sql = "update complaint set headremark = 'resolved' , status='resolved' where cid = ?";
		Connection connection = DbUtil.getConnection();
	    PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,cId);	
		logger.info("taking action on complaint");
		return ps.executeUpdate();
	}

	
}




