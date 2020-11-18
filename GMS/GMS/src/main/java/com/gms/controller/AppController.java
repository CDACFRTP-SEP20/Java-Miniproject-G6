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
import com.gms.model.DeptHead;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.HeadService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "citizen", "head" }))
public class AppController extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(AppController.class.getName());
	AdminService as = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//if user is admin redirect to admin-home page
		if (request.isUserInRole("admin")) {
			try {
				logger.info("Log in as a Admin");
				//calling getHeads function from AdminService
				List<DeptHead> user = as.getHeads();
				request.setAttribute("heads", user);
				request.getRequestDispatcher("/admin/admin-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//if user is citizen redirect to citizen-home page
		if (request.isUserInRole("citizen")) {
			logger.info("Log in  as a Citizen User");
			request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);
		}

		//if user is department head redirect to head-home page
		if (request.isUserInRole("head")) {
			logger.info("Log in  as a Department Head ");
			request.getRequestDispatcher("/head/head-home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
