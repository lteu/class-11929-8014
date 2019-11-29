// an undirected graph

import java.util.*;
 

 class Graph{

    HashMap<Integer, Set<Integer>> edges = new HashMap<>(); // adjacent edges
    Set<Integer> nodes = new HashSet<Integer>(); 

    ArrayList<Integer> adj(int v){
        if (edges.containsKey(v)) {
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	list.addAll(edges.get(v));
            return list;
        }
        return null;
    }

    void addEdge(int v1,int v2){ 
        add(v1,v2);
        nodes.add(v1);
        nodes.add(v2);
    }

    ArrayList<Integer> V(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(nodes);
        return list;
    }

    void add(int v1,int v2){
        if (!edges.containsKey(v1)) 
            edges.put(v1, new HashSet<Integer>());
       	if (!edges.containsKey(v2)) 
        	edges.put(v2, new HashSet<Integer>());
        
        // update adjacent lists
        edges.get(v1).add(v2); 
        edges.get(v2).add(v1); 
    }

    public static void main(String arg[])
	{
 		
 		Graph g = new Graph();
 		g.addEdge(3,5);
 		g.addEdge(2,5);
 		g.addEdge(1,5);
 		g.addEdge(8,2);
 		g.addEdge(6,2);

 		System.out.println(g.edges.toString());
	}

}

// similar implementation see: https://algs4.cs.princeton.edu/41graph/Graph.java.html
	