package com.gms.dao;

import java.util.List;

import com.gms.model.Users;

public interface IAdminDao {
	public int addHead(Users head)throws Exception;

	public List<Users> getHeads()throws Exception ;

	public int deleteHead(String username) throws Exception;

	public Users getHead(String username) throws Exception;

	public int updateHead(Users user) throws Exception;

}
