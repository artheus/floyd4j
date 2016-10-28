package se.artheus.velosiped;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDigraph<V extends Vertex> implements Digraph<V> {
  private final int size;
  private int edges;
  private int[] indegree;
  private VertexBag[] bags;

  public AbstractDigraph() {
    this(0);
  }

  @SuppressWarnings("unchecked")
  public AbstractDigraph(int size) {
    this.size = size;
    setUp(size);
  }

  public AbstractDigraph(Edge... edges) {
    List<Vertex> uniqueVertices = new ArrayList<Vertex>();
    int i = 0;

    // Calculate number of unique vertices, and give them id's
    for (Edge e : edges) {
      if(!uniqueVertices.contains(e.tail())) {
        e.tail().index(i++);
        uniqueVertices.add(e.tail());
      } else {
        // Assert index of vertex is same as last time, by setting it
        e.tail().index(
                uniqueVertices.get(
                        uniqueVertices.indexOf(e.tail())
                ).index()
        );
      }

      if(!uniqueVertices.contains(e.head())) {
        e.head().index(i++);
        uniqueVertices.add(e.head());
      } else {
        // Assert index of vertex is same as last time, by setting it
        e.head().index(
                uniqueVertices.get(
                        uniqueVertices.indexOf(e.head())
                ).index()
        );
      }
    }

    // Set digraph size
    this.size = uniqueVertices.size();
    setUp(size());

    // Add all edges to digraph
    for (Edge e : edges) {
      this.addEdge(e);
    }
  }

  private void setUp(int size) {
    if (size < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
    this.edges = 0;
    indegree = new int[size];
    bags = new VertexBag[size];
    for (int i = 0; i < size; i++) {
      bags[i] = new VertexBag();
    }
  }

  public int size() {
    return size;
  }

  public int edges() {
    return edges;
  }

  public boolean isWithinBounds(int index) {
    return !(index < 0 || index >= size());
  }

  public void addEdges(Edge... edges) {
    for (Edge e : edges) {
      this.addEdge(e);
    }
  }

  public void addEdge(Edge edge) {
    isWithinBounds(edge.tail().index());
    isWithinBounds(edge.head().index());
    bags[edge.tail().index()].add(edge.head());
    indegree[edge.head().index()]++;
    edges++;
  }

  @SuppressWarnings("unchecked")
  public Iterable<V> adj(int index) {
    if(!isWithinBounds(index))
      throw new IndexOutOfBoundsException();

    return (Iterable<V>) bags[index];
  }

  public int indegree(V vertex) {
    if(!isWithinBounds(vertex.index()))
      throw new IndexOutOfBoundsException();

    return bags[vertex.index()].size();
  }

  public int outdegree(V vertex) {
    if(!isWithinBounds(vertex.index()))
      throw new IndexOutOfBoundsException();

    return indegree[vertex.index()];
  }
}
