package com.gms.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.model.Users;
import com.gms.service.AdminService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin"}
				)
		)

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService as = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();

		//list heads
		if(path.equals("/listheads")) {			
			try {
				List<Users> xyz =  as.getHeads();
				request.setAttribute("heads", xyz);
				request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//add new dept head
		if(path.equals("/addhead")) {			
			try {
				Users head = new Users();
				head.setUsername(request.getParameter("username"));
				head.setPassword(request.getParameter("password"));
				head.setEmail(request.getParameter("email"));
				head.setPhoneNo(request.getParameter("phoneno"));
				head.setAddress(request.getParameter("address"));
				head.setRole(request.getParameter("role"));
				head.setDeptId(Integer.parseInt(request.getParameter("deptid")));
				as.addHead(head);
				response.sendRedirect("listheads");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//delete head
		if(path.equals("/deletehead")) {			
			try {
				as.deleteHead(request.getParameter("username"));
				request.setAttribute("deletemsg", "head deleted successfully");
				response.sendRedirect("listheads");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(path.equals("/edithead")) {			
			try {
				Users user = as.getHead(request.getParameter("username"));
				request.setAttribute("user", user);
				request.getRequestDispatcher("/admin/update-head.jsp").forward(request, response);								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/updatehead")) {			
			try {
				System.out.println("controller");
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				
				System.out.println(request.getParameter("username"));
				System.out.println(request.getParameter("email"));
				System.out.println(request.getParameter("phoneno"));
				System.out.println(request.getParameter("address"));
				System.out.println(request.getParameter("role"));
				System.out.println(request.getParameter("deptid"));
				
				user.setPassword(request.getParameter("password"));
				user.setEmail(request.getParameter("email"));
				user.setPhoneNo(request.getParameter("phoneno"));
				user.setAddress(request.getParameter("address"));
				user.setRole(request.getParameter("role"));
				user.setDeptId(Integer.parseInt(request.getParameter("deptid")));
				as.updateHead(user);
				response.sendRedirect("listheads");										
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
