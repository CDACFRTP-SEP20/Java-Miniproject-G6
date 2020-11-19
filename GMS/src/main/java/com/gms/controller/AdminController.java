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

import com.gms.model.DeptHead;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin" }))
public class AdminController extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(AdminController.class.getName());
	private static final long serialVersionUID = 1L;
	AdminService as = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		//list all heads
		if (path.equals("/listheads")) {
			try {
				logger.info("Getting List of Heads to te admin");
				//calling getHeads function for getting all department heads from AdminService
				List<DeptHead> user = as.getHeads();
				request.setAttribute("heads", user);
				request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
			} catch (Exception e) {
				logger.error("Not getting lsit of Heads to admin",e);
			}
		}

		//add new department head
		if (path.equals("/addhead")) {
			try {
				logger.info("Adding heads by Admin");
				Users head = new Users();
				head.setUsername(request.getParameter("username"));
				head.setPassword(request.getParameter("password"));
				head.setEmail(request.getParameter("email"));
				head.setPhoneNo(request.getParameter("phoneno"));
				head.setAddress(request.getParameter("address"));
				head.setRole(request.getParameter("role"));
				if (request.getParameter("dept").equals("water")) {
					head.setDeptId(1);
				} else if (request.getParameter("dept").equals("road")) {
					head.setDeptId(2);
				} else if (request.getParameter("dept").equals("electricity")) {
					head.setDeptId(3);
				} else {
					head.setDeptId(4);
				}
				//calling addHead function from AdminService
				as.addHead(head);
                HttpSession session = request.getSession();
                session.setAttribute("addhead", "Department head is added successfully");

				response.sendRedirect("listheads");
			} catch (Exception e) {
				logger.error("Fail to add Departmental heads by admin",e);
			}
		}
		
		//delete department head
		if (path.equals("/deletehead")) {
			try {
				logger.info("Deleting Heads by Admin");
				//calling deleteHead function from AdminService
				as.deleteHead(request.getParameter("username"));
				request.setAttribute("deletemsg", "head deleted successfully");
				response.sendRedirect("listheads");
			} catch (Exception e) {
				logger.error("Fail to Delete head by admin",e);
			}
		}
		
		//get department head which has to update
		if (path.equals("/gethead")) {
			try {
				logger.info("Getting Heads");
				//calling getHead funtion from AdminService
				Users user = as.getHead(request.getParameter("username"));
				request.setAttribute("user", user);
				request.getRequestDispatcher("/admin/update-head.jsp").forward(request, response);
			} catch (Exception e) {
				logger.error("Not getting Head to admin",e);
			}
		}
		
		//update department head
		if (path.equals("/updatehead")) {
			try {
				logger.info("Updating  Heads by Admin");
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setEmail(request.getParameter("email"));
				user.setPhoneNo(request.getParameter("phoneno"));
				user.setAddress(request.getParameter("address"));
				user.setRole(request.getParameter("role"));
				if (request.getParameter("dept").equals("water")) {
					user.setDeptId(1);
				} else if (request.getParameter("dept").equals("road")) {
					user.setDeptId(2);
				} else if (request.getParameter("dept").equals("electricity")) {
					user.setDeptId(3);
				} else {
					user.setDeptId(4);
				}
				
				//calling updateHead function from AdminService
				as.updateHead(user);
				response.sendRedirect("listheads");
			} catch (Exception e) {
				logger.error("Fail to update head",e);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
