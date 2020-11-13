package com.gms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.model.DeptHead;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin" }))
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService as = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		//function for list all heads
		if (path.equals("/listheads")) {
			try {
				List<DeptHead> user = as.getHeads();
				request.setAttribute("heads", user);
				request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//function for adding new dept head
		if (path.equals("/addhead")) {
			try {
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
				as.addHead(head);
				response.sendRedirect("listheads");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//function for deleting department head
		if (path.equals("/deletehead")) {
			try {
				as.deleteHead(request.getParameter("username"));
				request.setAttribute("deletemsg", "head deleted successfully");
				response.sendRedirect("listheads");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//function for getting department head which has to update
		if (path.equals("/gethead")) {
			try {
				Users user = as.getHead(request.getParameter("username"));
				request.setAttribute("user", user);
				request.getRequestDispatcher("/admin/update-head.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//function for updating department head
		if (path.equals("/updatehead")) {
			try {
				System.out.println("controller");
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

				// user.setDeptId(Integer.parseInt(request.getParameter("deptid")));
				as.updateHead(user);
				response.sendRedirect("listheads");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
