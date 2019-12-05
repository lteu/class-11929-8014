// Kosaraju's algorithm for connected components of directed graph

import java.util.*; 
class Digraph extends Graph{
    @Override
    void add(int v1,int v2){
        if (!edges.containsKey(v1)) 
            edges.put(v1, new HashSet<Integer>());
        
        edges.get(v1).add(v2); 
    }
}

public class Kosaraju {

    private HashMap<Integer, Boolean> visited = new HashMap<>(); 
    private HashMap<Integer, Integer> assigned = new HashMap<>(); 
    private Stack<Integer> L = new Stack<Integer>();

    public Kosaraju(Digraph G){
        // For each vertex u of the graph, mark u as unvisited. Let L be empty.

        for(int i:G.V()){
            visited.put(i,false);
        }

        // visit with DFS
        for(int i:G.V()){
            visit(G,i);
        }

        // assign with DFS
        while(!L.isEmpty()){
            int item = L.pop();
            assign(G,item,item);
        }

        System.out.println(assigned.toString());
    }

    private void visit(Digraph G,int v){

        if (!visited.get(v)) {
            visited.put(v,true);

            if (G.adj(v) != null) 
            for(int i:G.adj(v)){
                visit(G,i);
            }
            L.push(v);
        }
    }

    private void assign(Digraph G,int v, int root){

        if (!assigned.containsKey(v)) {
            assigned.put(v,root);

            if (G.adj(v) != null) 
            for(int i:G.adj(v)){
                assign(G,i,root);
            }
        }
    }

    public static void main(String arg[])
    {
        Digraph g = new Digraph(); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(5, 2); 
        g.addEdge(7, 10); 
        g.addEdge(10, 11); 
 
        Kosaraju kosaraju  = new Kosaraju(g);

    }
}

// https://en.wikipedia.org/wiki/Kosaraju%27s_algorithm
// https://www.youtube.com/watch?v=RpgcYiky7uw