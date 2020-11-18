package com.gms.service;

import java.util.List;

import com.gms.dao.AdminDaoImpl;
import com.gms.dao.IAdminDao;
import com.gms.model.DeptHead;
import com.gms.model.Users;

public class AdminService {

	//instance of iAdmindao interface
	IAdminDao adminDao = new AdminDaoImpl();
	
	//function for adding new department head
	public int addHead(Users head) throws Exception{
		return adminDao.addHead(head);
	}
	
	//function for getting all department heads
	public List<DeptHead> getHeads()throws Exception  {
		return adminDao.getHeads();
	}
	
	//function for deleting department head
	public int deleteHead(String username) throws Exception {
		return adminDao.deleteHead(username);
	}
	
	//function for getting department head  which is needed for updating head
	public Users getHead(String username) throws Exception {
		return adminDao.getHead(username);
	}
	
	//function for updating department head
	public int updateHead(Users user) throws Exception {
		return adminDao.updateHead(user);
	}
}
