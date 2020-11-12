package com.gms.controller;

import java.io.IOException;
import java.util.List;

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
				if(request.getParameter("dept").equals("water")){
					complaint.setDeptId(1);
				}
				else if(request.getParameter("dept").equals("road")){
					complaint.setDeptId(2);
				}
				else if(request.getParameter("dept").equals("electricity")){
					complaint.setDeptId(3);
				}
				else {
					complaint.setDeptId(4);
				}
				
				complaint.setUserId(id);
				complaint.setStatus("pending");
				complaint.setHeadRemark("pending");
				cs.registerComplaint(complaint);
				request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);
				//response.sendRedirect("/citizen-home.jsp");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//list complaints
		if(path.equals("/listcomplaints")) {	
			
			
			System.out.println("Citizen name in list::"+session.getAttribute("citizenname"));
			try {
				List<Complaint> complaints =  cs.getComplaints(id);
				
				request.setAttribute("complaints", complaints);
				//response.sendRedirect("/citizen/view-complaints.jsp");
				request.getRequestDispatcher("/citizen/view-complaints.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//register citizen
		if(path.equals("/registercitizen")) {
			try {
			Users user=new Users();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setPhoneNo(request.getParameter("phoneno"));
			user.setAddress(request.getParameter("address"));
			user.setRole("citizen");
			
			
				cs.registerCitizen(user);
				response.sendRedirect("/GMS/index.jsp");	
				//request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
