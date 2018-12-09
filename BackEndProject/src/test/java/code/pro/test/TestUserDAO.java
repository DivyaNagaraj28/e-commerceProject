package code.pro.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.pro.dao.UserDAO;
import code.pro.model.UserDetails;

public class TestUserDAO {


    static UserDAO  userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("code.pro");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
    @Ignore
	@Test
	public void registerUserTest()
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername("Rathna");
		userDetails.setAddress("Chennai");
		userDetails.setEmailId("message@gmail.com");
		userDetails.setEnabled(true);
		userDetails.setMobileNo("9876543219");
		userDetails.setPassword("password@123");
		userDetails.setRole("User");
		userDetails.setCustomerName("Rathna Bhai");
	    assertTrue("Problem in adding the UserDetails",userDAO.registerUser(userDetails));
		
	}
	
	@Test
	public void updateUserTest()
	{
		UserDetails userDetails= userDAO.getUser("Rathna");
	    userDetails.setAddress("Delhi");
		
		assertTrue("Problem in updating the UserDetails",userDAO.updateUser(userDetails));
		
	}
	
	
	}
	
  
		



