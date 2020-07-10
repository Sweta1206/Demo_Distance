package com.mastercard.demo;



import org.junit.jupiter.api.Test;
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

@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Mock
	RouteService routeService;
	
	
	@Test
	public void testFindRoute()
	{
	   
		when (routeService.getConnection(any(Routes.class))).thenReturn("result");
	  
	     assertEquals("result", "true");
	    //Verify request succeed
	   
	    
	}

}
