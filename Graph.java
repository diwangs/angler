import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public static void solveTravelingSalesmanProblem(Graph g){
      System.out.println("\nTraveling Salesman Problem Solution:");
      
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