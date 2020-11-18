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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.CitizenService;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "citizen" }))
public class CitizenController extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(CitizenController.class.getName());
	private static final long serialVersionUID = 1L;
	CitizenService cs = new CitizenService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		//creating Http session object for getting citizen name
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("citizenname");
		int id=0;
		try {
		
			id = cs.getId((String)session.getAttribute("citizenname"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//register new complaint 
		if(path.equals("/registercomplaint")) {			
			try {
				logger.info("Citizen User Register the complaint");
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
				//calling registerComplaint function from CitizenService
				cs.registerComplaint(complaint);
				request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);							
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//list previous complaints of citizen
		if(path.equals("/listcomplaints")) {	
			try {
				logger.info("Citizen User checkig our registered complaints");
				//calling getComplaints function from CitizenService
				List<ComplaintObject> complaints =  cs.getComplaints(id);
				request.setAttribute("complaints", complaints);
				request.getRequestDispatcher("/citizen/view-complaints.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//register new citizen
		if(path.equals("/registercitizen")) {
			try {
				logger.info("User Register as a Citizen");
				Users user=new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setEmail(request.getParameter("email"));
				user.setPhoneNo(request.getParameter("phoneno"));
				user.setAddress(request.getParameter("address"));
				user.setRole("citizen");
				//calling registerCitizen function from CitizenService
				cs.registerCitizen(user);
				response.sendRedirect("/GMS/login.jsp");	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
