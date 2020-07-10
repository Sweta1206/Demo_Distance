package com.mastercard.demo.service;
import java.util.*;

public class Graph {
	
	
	private Map<String, List<String>> connections = new HashMap<>();
	
	
	void addCities(String city) {
	//	System.out.println("Label inside Graph "+city);
	    connections.put(city, new ArrayList<String>());
	}
	 
	
	void addEdge(String source, String dest) {
	    connections.get(source).add(dest);
	//    adjVertices.get(v2).add(v1);
	}

	
	void printGraph()
	{
		
       for(Map.Entry<String, List<String>> e : connections.entrySet() )
       {
    	   System.out.print(e.getKey()+" -> ");
    	   for (String v : e.getValue())
    	   {
			 System.out.print(v+" ");
    	   }
    	   System.out.println();
       }
	}
	
	boolean isReachable(String s, String d) 
	{
		System.out.println(s);
		System.out.println(d);
		HashSet<String> visited = new HashSet<>();
		
		LinkedList<String> queue = new LinkedList<String>();
		
		visited.add(s);
		
		queue.add(s);
		
		
		while(queue.size()!=0)
		{
			String s_poll = queue.poll();
			
			
			Iterator<String> itr = connections.get(s_poll).iterator();
			
			while(itr.hasNext())
			{
				String temp = itr.next();
				if(d.equals(temp))
				{
					return true;
				}
				
				if(!visited.contains(temp))
				{
					queue.add(temp);
					visited.add(temp);
				}
					
					
			}
		}
		
		return false;
		
	}
	
	
}
