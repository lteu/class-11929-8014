// Dato un grafo G=(V, E) ed un vertice r di V (detto sorgente o radice), visitare ogni vertice raggiungibile nel grafo dal vertice r
import java.util.*;
 
 
public class Dfs
{ 
 
	private Graph graph;
	private Queue<Integer> queue = new LinkedList<>();
	private HashMap<Integer, Boolean> visited = new HashMap<>();
	ArrayList<Integer> results = new  ArrayList<>();
	// Recursive DFS


	public Dfs(Graph g)
	{	
		for(int i : g.V()) {
			visited.put(i,false);
		}
		this.graph = g;
	}


	public void dfs(Integer node)
	{
		visited.put(node,true);
		results.add(node);
		for (int i : this.graph.adj(node)) {
			if(!visited.get(i))
			{	
				
				dfs(i);
			}
		}
	}
 
	public static void main(String arg[])
	{
 
		Graph g = new Graph(); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(5, 2); 
        g.addEdge(7, 10); 
        g.addEdge(10, 11); 

        Integer start_node = 0;
		Dfs dfsExample = new Dfs(g);
		dfsExample.dfs(start_node);
		System.out.println("Visited nodes starting from "+start_node+" are " + dfsExample.results.toString());
	}
}