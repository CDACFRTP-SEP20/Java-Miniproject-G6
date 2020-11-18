package com.gms.dao;

import java.util.List;

import com.gms.model.DeptHead;
import com.gms.model.Users;

public interface IAdminDao {
	
	//function for adding new department head
	public int addHead(Users head)throws Exception;

	//function for getting all department heads
	public List<DeptHead> getHeads()throws Exception ;

	//function for deleting department head
	public int deleteHead(String username) throws Exception;

	//function for getting department head  which is needed for updating head
	public Users getHead(String username) throws Exception;

	//function for updating department head
	public int updateHead(Users user) throws Exception;

}
