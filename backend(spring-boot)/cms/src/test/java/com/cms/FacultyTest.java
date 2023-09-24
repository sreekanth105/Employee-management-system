package com.cms;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import com.cms.model.Faculty;

@DisplayName("FacultyController")
public class FacultyTest {
	
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
		Faculty faculty = new Faculty();
		faculty.setFusername("Bikki");
		String ft= faculty.getFusername();
		
		assertEquals("Bikki",ft);
		System.out.print("\nTest case 2 passed");

	}
	
	@Test
	@Order(3)
	public void savepass() {
		Faculty ft= new Faculty();
		ft.setFpassword("Bikki");
		
		String faculty = ft.getFpassword();
		assertNotEquals("Bikki",ft);
		
		System.out.print("\nTest case 4 passed");

	}
	
	@AfterEach
	@Test
	public void test4() {
		System.out.print("\nAfter Setup");
	}
}
