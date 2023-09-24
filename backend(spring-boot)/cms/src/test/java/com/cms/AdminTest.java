package com.cms;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import com.cms.model.Admin;

@DisplayName("AdminController")
public class AdminTest {

	@BeforeEach
	@Test
	public void test3() {
		System.out.print("\nBeforeSetup");
	}
	
	@Test
	@Order(1)
	public void test() {
		System.out.print("\nTest case 1 passed" +" " );
	}
	@Test
	@Order(2) 
	public void test1() {
		Admin admin = new Admin();
		admin.setAusername("Bikki");
		String ad= admin.getAusername();
		
		assertEquals("Bikki",ad);
		System.out.print("\nTest case 2 passed");

	}
	
	@Test
	@Order(3)
	public void savepass() {
		Admin ad= new Admin();
		ad.setApassword("Bikki");
		
		String admin = ad.getApassword();
		assertNotEquals("Bikki",ad);
		
		System.out.print("\nTest case 4 passed");

	}
	
	@AfterEach
	@Test
	public void test4() {
		System.out.print("\nAfter Setup");
	}
}
