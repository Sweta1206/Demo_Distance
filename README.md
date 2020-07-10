#Demo_Distance

1. Create a bean for Routes to store source and destinations passed in the URL.
2. Create a controller class RequestController with @GetMapping and URI = "/connected/origin={origin}&destination={destination}" to get the Source and Destination.
  2.a. Check if source and destination are strings and doesnot contain digit.
  2.b. Call findRoute() which will calls service class method getConnection() which checks if the path exists between Source and Destination.
  2.c If path exists then getConnection() returns true else false.
3. Service class RouteService contains implementation logic withing getConnection method to check if path exist from source to destination.
  3.a Read file cities.txt and store the source and destinations as ArrayList of array having source and destination ArrayList<String[]> cities and array[Source,destination].
  3.b Store the source and destinations in a Set to get uniques nodes to generate a graph with vertex and connecting nodes.
  3.c Create a graph.class to define the graph structure which will be a Map with Key as unique cities and values as destination cities it is connected to. Graph.class will also   
      have methods to generate graph and traverse the graph.
  3.d Call addCities() of graph to define the unique cities as Key of Map.
  3.e Call addEdge() of graph to add connections from key i.e source to various destinates it can route to.
  3.f As the graph will be generated now the next step is to check if the source and destination pass are present in the vertexs or keys of Map. If yes call isReachable() method          
      of graph which contains the logic for traversing the map to check if there exists a path from source to destination.
      4) isReachable()
         4.a Set<> Visited contains the set of nodes of nodes already visited.
         4.b If not visited then add it to queue and mark it as visited. 
         4.c Poll the queue and if destination is found, then return true.
         4.d Poll the queue till the queue is empty and destination is not reached return false.
         
      
     
         
