// Dato un grafo G=(V, E) ed un vertice r di V (detto sorgente o radice), visitare ogni vertice raggiungibile nel grafo dal vertice r
import java.util.*;
 
public class Bfs
{ 
 	
 	private Graph graph;
	private Queue<Integer> queue = new LinkedList<>();
	private HashMap<Integer, Boolean> visited = new HashMap<>();
	ArrayList<Integer> results = new  ArrayList<>();
	
	public Bfs(Graph g)
	{	
		for(int i : g.V()) {
			visited.put(i,false);
		}
		this.graph = g;
	}
 
	public void bfs(Integer node)
	{
		queue.add(node);
		visited.put(node,true);
		results.add(node);
		while (!queue.isEmpty())
		{
 
			Integer aNode=queue.remove();
			for (int i : this.graph.adj(aNode)) {
				if( !visited.get(i))
				{
					queue.add(i);
					visited.put(i,true);
 					results.add(i);
				}
				
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
		Bfs bfsExample = new Bfs(g);
		bfsExample.bfs(start_node);
	 	System.out.println("Visited nodes starting from "+start_node+" are " + bfsExample.results.toString());
	}
}

// rif https://java2blog.com/breadth-first-search-in-java/