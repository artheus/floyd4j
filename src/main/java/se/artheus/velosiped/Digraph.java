package se.artheus.velosiped;

public interface Digraph<V extends Vertex> {

  /**
   * @return int Total number of vertices in {@link Digraph}
   */
  int size();

  /**
   * @return int Total number of edges in {@link Digraph}
   */
  int edges();

  /**
   * Validate that a vertex index exists
   *
   * @param index int index of vertex
   * @return boolean flag indicating if vertex index exists in {@link Digraph}
   */
  boolean isWithinBounds(int index);

  /**
   * Add edge to {@link Digraph}
   *
   * @param edge {@link Edge}
   */
  void addEdge(Edge edge);

  /**
   * Return an iterable adjacent to the provided vertex index
   *
   * @param index int index of vertex in digraph
   * @return {@link Iterable<V>}
   */
  Iterable<V> adj(int index);

  /**
   * Number of edges incident to vertex {@link V}
   *
   * @param vertex {@link V}
   * @return int
   */
  int indegree(V vertex);

  /**
   * Number of edges incident from vertex {@link V}
   *
   * @param vertex {@link V}
   * @return int
   */
  int outdegree(V vertex);
}
