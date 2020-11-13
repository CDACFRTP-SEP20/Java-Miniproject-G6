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
import com.gms.model.ComplaintObject;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.HeadService;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "head" }))
public class HeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HeadService hs = new HeadService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		//creating Http session object for getting department head name
		HttpSession session = request.getSession();
		String headName = (String) session.getAttribute("headName");

		//list all complaints of particular department head
		if (path.equals("/listcomplaints")) {
			try {
				//calling getComplaints function from HeadService(pending complaints)
				List<ComplaintObject> complaints = hs.getComplaints(headName);
				request.setAttribute("complaints", complaints);
				//calling getResolvedComplaints function from HeadService(resolved complaints)
				List<ComplaintObject> resolvedComplaints = hs.getResolvedComplaints(headName);
				request.setAttribute("resolvedComplaints", resolvedComplaints);
				request.getRequestDispatcher("/head/show-complaints.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//redirect to transfer complaint page
		if (path.equals("/transferComplaintpage")) {
			try {
				session.setAttribute("cmpid", request.getParameter("cid"));
				int cmpId = Integer.parseInt((String) session.getAttribute("cmpid"));
				request.getRequestDispatcher("/head/transfercomplaint.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//transfer complaint to another department
		if (path.equals("/transferComplaint")) {
			int cmpId = Integer.parseInt((String) session.getAttribute("cmpid"));
			try {
				//calling getDeptIdByDeptName function from HeadService
				int id = hs.getDeptIdByDeptName(request.getParameter("depts"));
				//calling updateDeptId function from HeadService
				hs.updateDeptId(id, cmpId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("listcomplaints");
		}

		//take action on complaint
		if (path.equals("/takeAction")) {
			int cid = Integer.parseInt((String) request.getParameter("cid"));
			try {
				//calling takeAction function from HeadService
				hs.takeAction(cid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("listcomplaints");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
