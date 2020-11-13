
package com.gms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;
import com.gms.model.Users;

public class CitizenDaoImpl implements ICitizenDao {

	//function to register complaint
	public int registerComplaint(Complaint complaint) throws Exception {
		String sql = "insert into complaint (description,userremark,status,deptid,headremark,userId) values(?,?,?,?,?,?)";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, complaint.getDescription());
		ps.setString(2, complaint.getUserRemark());
		ps.setString(3,complaint.getStatus());
		ps.setInt(4,complaint.getDeptId());
		ps.setString(5,complaint.getHeadRemark());
		ps.setInt(6,complaint.getUserId());
		return ps.executeUpdate();
	}
	  
	//function for get userId by username
	public  int getId(String username) throws Exception {
		String sql="select userid from users where username=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		int id=0;
		while (rs.next()) {
			id=rs.getInt("userid");
		}
		return id;
	}

	//function for getting complaints of particular citizen
	public List<ComplaintObject> getComplaints(int id) throws Exception{
		String sql="select c.cid,u.username,d.deptname,c.description,c.userremark,c.headremark,c.status,c.screenshot from complaint c join users u on c.userId=u.userId join department d on c.deptId=d.deptId where c.userId=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<ComplaintObject> complaints = new ArrayList<ComplaintObject>();
		while (rs.next()) {
			complaints.add(new ComplaintObject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getBytes(8)));
		}
		return complaints;
	}
	
	//function for registering new citizen
	public int registerUser(Users user)throws Exception {
		String sql = "insert into users (username,password,email,phoneno,address,role) values( ?,?,?,?,?,?)";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getEmail());
		ps.setString(4,user.getPhoneNo());
		ps.setString(5,user.getAddress());
		ps.setString(6,user.getRole());
		return ps.executeUpdate();
	}
}
	

