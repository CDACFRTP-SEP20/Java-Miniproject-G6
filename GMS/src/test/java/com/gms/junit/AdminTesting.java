
  package com.gms.junit;
  
  import static org.junit.jupiter.api.Assertions.*;
  
  import org.junit.jupiter.api.Test;
  
  import com.gms.model.Users; import com.gms.service.AdminService;
  
  class AdminTesting {
  
  AdminService service=new AdminService();
  
  
  @Test
  void testAddHead() throws Exception { 
	  //checking if deptHead
  
 // registration is done or not... 
  Users u= new Users("prajakta", "123","prajakta@gmail.com", "7058945732", "pune", "head",2);
  //please put the
  //appropriate userId from userTable... 
  assertEquals(1, service.addHead(u));
  }
  
  @Test void testGetHeads() throws Exception {
  assertNotNull(service.getHeads()); 
  }
  
  @Test void testDeleteHead() throws Exception {
  
  assertEquals(1, service.deleteHead("john")); }
  
  @Test void testGetHead() throws Exception{
  assertNotNull(service.getHead("prajakta"));
  }
  
  @Test
  void testUpdateHead() throws Exception { 
	  //after successful
  
  //updation, excuteUpdate() returns 1, else 0... //checking if status updation
  //is done or not... // 
  Users u= new Users("prajakta", "123","prajakta@gmail.com", "7058945732", "nagpur", "head",2);
    assertEquals(1,service.updateHead(u));
  }
  
  }
 
