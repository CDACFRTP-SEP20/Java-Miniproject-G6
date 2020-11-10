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

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin", "citizen", "head"}
				)
		)
public class AppController extends HttpServlet {
	AdminService as=new AdminService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);
		}
		if(request.isUserInRole("member")) {
			request.getRequestDispatcher("/head/head-home.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
