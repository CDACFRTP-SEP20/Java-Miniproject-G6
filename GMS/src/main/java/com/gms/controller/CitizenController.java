package com.gms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gms.model.Complaint;
import com.gms.model.ComplaintObject;
import com.gms.model.Users;
import com.gms.service.AdminService;
import com.gms.service.CitizenService;

///@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "citizen" }))
@MultipartConfig(maxFileSize = 16177215)//upload upto 16MB 
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
		} catch (Exception e) {
			logger.error("Fail to get User id of user",e);
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
				logger.error("Not getting lsit of complaints to citizen user",e);
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
                HttpSession session1 = request.getSession();
                session1.setAttribute("registerdmsg", "User registered  successfully");

				response.sendRedirect("/GMS/login.jsp");	
			} catch (Exception e) {
				logger.error("Citizen registration failed",e);
				
			}
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      String path = request.getPathInfo();

      //creating Http session object for getting citizen name
      HttpSession session=request.getSession();
      String name=(String) session.getAttribute("citizenname");
      int id=0;
      try {
            id = cs.getId((String)session.getAttribute("citizenname"));
      } catch (Exception e1) {
            logger.error("session failed...",e1);
      }

      //register new complaint 
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


                  Part filePart = request.getPart("screenshot"); 
                  String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString()+"/"; 
                  InputStream fileContent = filePart.getInputStream();
                  complaint.setScreenshot(fileContent);    
                  System.out.println(fileName);

                  //calling registerComplaint function from CitizenService
                  cs.registerComplaint(complaint);
                  request.getRequestDispatcher("/citizen/citizen-home.jsp").forward(request, response);                                        
            } catch (Exception e) {
                  logger.error("complaint registration failed...",e);

            }
      }

      doGet(request, response);
}


}
