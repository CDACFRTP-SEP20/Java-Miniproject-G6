package com.gms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.model.Complaint;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.CitizenService;

/**
 * Servlet implementation class CitizenController
 */
public class CitizenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CitizenService cs = new CitizenService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		//HttpSession session1=request.getSession();
		HttpSession session=request.getSession();
		System.out.println("Citizen name::"+session.getAttribute("citizenname"));
		String name=(String) session.getAttribute("citizenname");
		//System.out.println("username"+username);
		int id=0;
		try {
			id = cs.getId((String)session.getAttribute("citizenname"));
			System.out.println("userId1::::"+id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("userId2::::"+id);
		//register new complain 
		if(path.equals("/registercomplaint")) {			
			try {
				
				Complaint complaint = new Complaint();
				complaint.setDescription(request.getParameter("description"));
				complaint.setUserRemark(request.getParameter("remark"));
				complaint.setStatus(request.getParameter("status"));
				complaint.setDeptId(Integer.parseInt(request.getParameter("deptid")));
				complaint.setUserId(id);
				complaint.setStatus("pending");
				complaint.setHeadRemark("pending");
				cs.registerComplaint(complaint);
				//request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);
				response.sendRedirect("citizen-home.jsp");								
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
