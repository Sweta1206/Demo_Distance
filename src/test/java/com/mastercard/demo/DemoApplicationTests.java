package com.mastercard.demo;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import com.mastercard.demo.bean.Routes;
import com.mastercard.demo.controller.RequestController;
import com.mastercard.demo.service.RouteService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

//	@Mock
//	RouteService routeService;
	
//	@Mock
//	Routes r = new Routes();
	
	
	@Autowired
	RouteService routeService1;
	
	
	//@Test
	/*public void testFindRoute()
	{
	   
		when (routeService.getConnection(any(Routes.class))).thenReturn("result");
	  
	     assertEquals(routeService.getConnection(r), "result");
	    //Verify request succeed     
	}
	*/
	@Test
	public void testGetConnection()
	{
		Routes r1 = new Routes();
		r1.setDestination("New York");
		r1.setOrigin("Newark");
		
		String result = routeService1.getConnection(r1);
		System.out.println(result);
		
		assertEquals(result, "true");
		
	}
	
	
	@Test 
	public void testGetConnection1()
	{
		Routes r1 = new Routes();
		r1.setDestination("New York");
		r1.setOrigin("1234");
		
		String result = routeService1.getConnection(r1);
		System.out.println(result);
		
		assertEquals(result, "false");
		
	}
	
	
	@Test
	public void testGetConnection2()
	{
		Routes r1 = new Routes();
		r1.setDestination("New York");
		r1.setOrigin("abc");
		
		String result = routeService1.getConnection(r1);
		System.out.println(result);
		
		assertEquals(result, "false");
		
	}
	
	@Test
	public void testGetConnection3()
	{
		Routes r1 = new Routes();
		r1.setDestination(null);
		r1.setOrigin("New York");
		
		String result = routeService1.getConnection(r1);
		System.out.println(result);
		
		assertEquals(result, "false");
		
	}
	
	

}
