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

}
