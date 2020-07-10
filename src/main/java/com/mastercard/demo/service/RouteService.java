package com.mastercard.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mastercard.demo.bean.Routes;

@Service
public class RouteService {
	
	public String getConnection(Routes routes)
	{
		 File file = new File("C:\\Users\\sweta\\Downloads\\demo\\src\\main\\resources\\cities.txt"); 
		  HashSet<String> set = new HashSet<>();
		 Scanner myReader;
		 Boolean result= false;
		try {
			ArrayList<String[]> cities = new ArrayList<>();
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
	//	        System.out.println(data);
		        
		        String[] array = data.split(",");
		        cities.add(array);
		        
		      }
			
			for(int i =0; i<cities.size();i++)
			{
	//			System.out.println(cities.get(i)[0]+" "+cities.get(i)[1]);
				set.add(cities.get(i)[0]);
				set.add(cities.get(i)[1]);
			}
			
			
			Graph graph = new Graph();
			for(String s:set)
			{
		//		System.out.println("Set :"+s);
				graph.addCities(s.trim());
			}
			
			for(int i =0; i<cities.size();i++)
			{
			//	System.out.println(cities.get(i)[0]+" "+cities.get(i)[1]);
			//	set.add(cities.get(i)[0]);
			//	set.add(cities.get(i)[1]);
				graph.addEdge(cities.get(i)[0].trim(),cities.get(i)[1].trim());
			
			}
			graph.printGraph();
			
			if(routes.getOrigin()!=null && routes.getDestination() !=null)
			{
			String origin = routes.getOrigin().toString().trim();
			String destination = routes.getDestination().toString().trim();
			
			
			if(set.contains(origin) && set.contains(destination))
			{
			result = graph.isReachable(routes.getOrigin().toString().trim(), routes.getDestination().toString().trim());
			}
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		
	
		return result.toString();
	
	}

}
