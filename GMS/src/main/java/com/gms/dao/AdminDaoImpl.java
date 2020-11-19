package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.model.DeptHead;
import com.gms.model.Users;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminDaoImpl implements IAdminDao {
	public static final Logger logger = LogManager.getLogger(AdminDaoImpl.class.getName());
	//function for adding new department head
	public int addHead(Users head) throws Exception {
		String sql = "insert into users (username,password,email,phoneno,address,role,deptid) values(?,?,?,?,?,?,?)";
		try(Connection connection = DbUtil.getConnection();PreparedStatement ps = connection.prepareStatement(sql))
		{
		
		
		ps.setString(1, head.getUsername());
		ps.setString(2, head.getPassword());
		ps.setString(3, head.getEmail());
		ps.setString(4, head.getPhoneNo());
		ps.setString(5, head.getAddress());
		ps.setString(6, "head");
		ps.setInt(7, head.getDeptId());
		logger.info("Admin Adding head into the Database");
		return ps.executeUpdate();
		}
	}

	//function for getting all department heads
	public List<DeptHead> getHeads() throws Exception {
		String sql = "select u.username, u.email, u.phoneno, u.address, d.deptname, u.role from users u join department d on u.deptid=d.deptid";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<DeptHead> heads = new ArrayList<DeptHead>();
		while (rs.next()) {
			//if users has head role then only add into temporary head list
			if (rs.getString("role").equals("head")) {
				heads.add(new DeptHead(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5)));
			}
		}
		logger.info("getting Heads");
		return heads;
	}
	
	//function for deleting department head
	public int deleteHead(String username) throws Exception{
		String sql = "delete from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, username);		
		logger.info("Deleting Head from Database");
		return ps.executeUpdate();
	}

	//function for getting department head  which is needed for updating head
	public Users getHead(String username) throws Exception {
		String sql = "select * from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Users  user = null;
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getInt(8));
		}
		logger.info("getting department head  which is needed for updating head");
		return user;
	}

	//function for updating department head
	public int updateHead(Users user) throws Exception {
		String sql = "update users set password = ? , email=? , phoneno=? , address=? , role=? , deptid=? where username = ?";
		Connection connection = DbUtil.getConnection();		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPhoneNo());
		ps.setString(4, user.getAddress());
		ps.setString(5, "head");
		ps.setInt(6, user.getDeptId());
		ps.setString(7, user.getUsername());
		logger.info("Updating Department Head");
		return ps.executeUpdate();
	}
}
