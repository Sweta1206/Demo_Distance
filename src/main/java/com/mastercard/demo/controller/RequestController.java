package com.mastercard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.demo.bean.Routes;
import com.mastercard.demo.service.RouteService;

@RestController
public class RequestController {
	
	@Autowired
	RouteService routeService;
	
	@GetMapping("/connected/origin={origin}&destination={destination}")
	public @ResponseBody String findRoute(@PathVariable String origin, @PathVariable String destination)
	{
		if(origin.matches(".*\\d.*")||destination.matches(".*\\d.*"))
		{
			return "Please try with correct source and destination";
		}
		
		Routes routes = new Routes();
		routes.setOrigin(origin);
		routes.setDestination(destination);
		String result = routeService.getConnection(routes);
		return result;
		
	}

}
