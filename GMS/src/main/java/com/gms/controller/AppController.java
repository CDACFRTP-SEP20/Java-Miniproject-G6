package com.gms.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.model.Complaint;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.HeadService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin", "citizen", "head"}
				)
		)
public class AppController extends HttpServlet {
	AdminService as=new AdminService();
	HeadService hs=new HeadService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("j_username");
		System.out.println(username);
		System.out.println("hello");
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
		if(request.isUserInRole("admin")) {
			try {
				List<Users> xyz =  as.getHeads();
				request.setAttribute("heads", xyz);
				request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
		}
		
			
		
		if(request.isUserInRole("citizen")) {
			System.out.println("name==="+session.getAttribute("user"));
			HttpSession session1=request.getSession();
			session1.setAttribute("name",request.getParameter("j_username"));
			
			request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);
		}
		if(request.isUserInRole("head")) {
			System.out.println("in head");
			try {
				List<Complaint> complaints =  hs.getComplaints();
				request.setAttribute("complaints", complaints);
				request.getRequestDispatcher("/head/head-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//request.getRequestDispatcher("/head/head-home.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
