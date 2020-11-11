package com.gms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.model.Complaint;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.HeadService;

/**
 * Servlet implementation class HeadController
 */
public class HeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HeadService hs = new HeadService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		//list heads
		if(path.equals("/listcomplaints")) {			
			try {
				List<Complaint> complaints =  hs.getComplaints();
				request.setAttribute("complaints", complaints);
				request.getRequestDispatcher("head-home.jsp").forward(request, response);
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
