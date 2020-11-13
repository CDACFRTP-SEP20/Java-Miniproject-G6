/*
 * package com.gms.junit;
 * 
 * import static org.junit.jupiter.api.Assertions.*;
 * 
 * import org.junit.jupiter.api.Test;
 * 
 * import com.gms.model.Complaint; import com.gms.model.Users; import
 * com.gms.service.CitizenService;
 * 
 * class CitizenTest { CitizenService service=new CitizenService();
 * 
 * @Test void testRegisterComplaint() throws Exception {
 * 
 * Complaint c= new
 * Complaint(3,1,"water Realated","Urgent","pending","pending",null); //please
 * put the appropriate userId from userTable...
 * assertEquals(1,service.registerComplaint(c)); }
 * 
 * @Test void testGetId() throws Exception {
 * 
 * assertEquals(14,service.getId("prajakta")); }
 * 
 * @Test void testGetComplaints() throws Exception {
 * assertNotNull(service.getComplaints(14));
 * 
 * }
 * 
 * @Test void testRegisterCitizen() throws Exception { Users u= new
 * Users("shraddha", "123", "shraddha@gmail.com", "7058945732", "pune",
 * "citizen");
 * 
 * assertEquals(1,service.registerCitizen(u)); }
 * 
 * }
 */