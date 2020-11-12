package com.gms.service;

import java.util.List;

import com.gms.dao.AdminDaoImpl;
import com.gms.dao.IAdminDao;
import com.gms.model.Users;

public class AdminService {

	
	IAdminDao adminDao = new AdminDaoImpl();
	public int addHead(Users head) throws Exception{
		return adminDao.addHead(head);
	}
	public List<Users> getHeads()throws Exception  {
		return adminDao.getHeads();

	}
	public int deleteHead(String username) throws Exception {
		return adminDao.deleteHead(username);
	}
	public Users getHead(String username) throws Exception {
		return adminDao.getHead(username);
	}
	public int updateHead(Users user) throws Exception {
		return adminDao.updateHead(user);
	}
}
