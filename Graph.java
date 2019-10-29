import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.lang.*;

public class Graph {

    private List<Edge> edges;
    private Set<Vertex> vertices;
  
    public Graph() {
      edges = new ArrayList<>();
      vertices = new TreeSet<>();
    }
    public void addEdge(Edge edge){
      getEdges().add(edge);
      getVertices().add(edge.getFromVertex());
      getVertices().add(edge.getToVertex());
    }
    
    public void addVertice(Vertex v){
      getVertices().add(v);
    }
  
    public List<Edge> getEdges() {
      return edges;
    }
  
    public Set<Vertex> getVertices() {
      return vertices;
    }
    
    public static void printGraph(Graph g){
      System.out.println("~Graph~");
      System.out.println("Vertices...");
      for (Vertex v : g.getVertices()) {
        System.out.print(v.getLabel() + " ");
      }
      System.out.println("");
      System.out.println("Edges...");
      for (Edge e : g.getEdges()) {
        System.out.println(e);
      }
    }

    public static int tsp(int[][] graph, boolean[] v,  
                   int currPos, int n,  
                   int count, int cost, int ans)  
    { 
  
        // If last node is reached and it has a link 
        // to the starting node i.e the source then 
        // keep the minimum value out of the total cost 
        // of traversal and "ans" 
        // Finally return to check for more possible values 
        if (count == n && graph[currPos][0] > 0)  
        { 
            ans = Math.min(ans, cost + graph[currPos][0]); 
            return ans; 
        } 
  
        // BACKTRACKING STEP 
        // Loop to traverse the adjacency list 
        // of currPos node and increasing the count 
        // by 1 and cost by graph[currPos,i] value 
        for (int i = 0; i < n; i++)  
        { 
            if (v[i] == false && graph[currPos][i] > 0)  
            { 
  
                // Mark as visited 
                v[i] = true; 
                ans = tsp(graph, v, i, n, count + 1, 
                          cost + graph[currPos][i], ans); 
  
                // Mark ith node as unvisited 
                v[i] = false; 
            } 
        } 
        return ans; 
    } 

    public static void solveTravelingSalesmanProblem(Graph g){
      System.out.println("\nTraveling Salesman Problem Solution:");
      // n is the number of nodes i.e. V 
      int n = g.getVertices().size(); 
      // System.out.println(Character.getNumericValue(g.getVertices[0]));

      int[][] graph = new int[n+1][n+1]; 

      for (Edge e : g.getEdges()) {
        graph[Character.getNumericValue(e.getFromVertex().getLabel().charAt(0)) - 10][Character.getNumericValue(e.getToVertex().getLabel().charAt(0)) - 10] = (int)((double)e.getWeight());
      }

      // Boolean array to check if a node 
      // has been visited or not 
      boolean[] v = new boolean[n]; 

      // Mark 0th node as visited 
      v[0] = true; 
      int ans = Integer.MAX_VALUE; 

      // Find the minimum weight Hamiltonian Cycle 
      ans = tsp(graph, v, 0, n, 1, 0, ans); 

      // Minimum weight Hamiltonian Cycle 
      System.out.println("Minimum weight Hamiltonian Cycle: " + ans); 
    }
  
  }
  
  class Edge {
  
    private Vertex fromVertex;
    private Vertex toVertex;
    private Double weight;
  
    public Edge() {
    }
  
    public Edge(Vertex fromVertex, 
            Vertex toVertex, 
            Double weight) {
      this.fromVertex = fromVertex;
      this.toVertex = toVertex;
      this.weight = weight;
    }
  
    @Override
    public String toString() {
      return fromVertex.getLabel() + 
              " to " + toVertex.getLabel() + 
              " with weight " + getWeight();
    }
  
    public Vertex getFromVertex() {
      return fromVertex;
    }
  
    public void setFromVertex(Vertex fromVertex) {
      this.fromVertex = fromVertex;
    }
  
    public Vertex getToVertex() {
      return toVertex;
    }
  
    public void setToVertex(Vertex toVertex) {
      this.toVertex = toVertex;
    }
  
    public Double getWeight() {
      return weight;
    }
  
    public void setWeight(Double weight) {
      this.weight = weight;
    }
  }
  
  class Vertex implements Comparable<Vertex> {
    private String label;
  
    public Vertex(String label) {
      this.label = label.toUpperCase();
    }
    
    @Override
    public int compareTo(Vertex o) {
      return (this.getLabel().compareTo(o.getLabel()));
    }
  
    public String getLabel() {
      return label;
    }
  
    public void setLabel(String label) {
      this.label = label;
    }
  }