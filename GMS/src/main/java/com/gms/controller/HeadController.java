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
import com.gms.service.HeadService;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "head" }))
public class HeadController extends HttpServlet {
                public static final Logger logger = LogManager.getLogger(HeadController.class.getName());
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
                                                                logger.info("Departmental Head Checking all complaints related to own Department");
                                                                //calling getComplaints function from HeadService(pending complaints)
                                                                List<ComplaintObject> complaints = hs.getComplaints(headName);
                                                                request.setAttribute("complaints", complaints);
                                                                //calling getResolvedComplaints function from HeadService(resolved complaints)
                                                                List<ComplaintObject> resolvedComplaints = hs.getResolvedComplaints(headName);
                                                                request.setAttribute("resolvedComplaints", resolvedComplaints);
                                                                request.getRequestDispatcher("/head/show-complaints.jsp").forward(request, response);
                                                } catch (Exception e) {
                                                	logger.error("Not getting complaints to respective department",e);
                                                }
                                }
                                
                                //redirect to transfer complaint page
                                if (path.equals("/transferComplaintpage")) {
                                                try {
                                                                logger.info("Try to transfer complaint");
                                                                session.setAttribute("cmpid", request.getParameter("cid"));
                                                                int cmpId = Integer.parseInt((String) session.getAttribute("cmpid"));
                                                                request.getRequestDispatcher("/head/transfercomplaint.jsp").forward(request, response);
                                                } catch (Exception e) {
                                                	logger.error("Fail to redirect transfer complaint page",e);
                                                }

                                }
                                
                                //transfer complaint to another department
                                if (path.equals("/transferComplaint")) {
                                                int cmpId = Integer.parseInt((String) session.getAttribute("cmpid"));
                                                try {
                                                                logger.info("Head Transfering complete to the respective Department");
                                                                //calling getDeptIdByDeptName function from HeadService
                                                                System.out.println("deptname::"+request.getParameter("depts"));
                                                                int id = hs.getDeptIdByDeptName(request.getParameter("depts"));
                                                //            System.out.println("dept id="+id);
                                                                //System.out.println("cmp id="+cmpId);
                                                                
                                                                //calling updateDeptId function from HeadService
                                                                hs.updateDeptId(id, cmpId);
                                                } catch (Exception e) {
                                                	logger.error("fail to transfer complaint",e);
                                                }
                                                response.sendRedirect("listcomplaints");
                                }

                                //take action on complaint
                                if (path.equals("/takeAction")) {
                                                int cid = Integer.parseInt((String) request.getParameter("cid"));
                                                try {
                                                                logger.info("Head taking some action on respective complaint");
                                                                //calling takeAction function from HeadService
                                                                hs.takeAction(cid);
                                                } catch (Exception e) {
                                                	logger.error("Fail to take action on Complaint",e);
                                                }
                                                response.sendRedirect("listcomplaints");
                                }
                }

                protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {
                                doGet(request, response);
                }
}
