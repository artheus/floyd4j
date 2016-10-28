package se.artheus.floyd4j.digraph;

import se.artheus.floyd4j.AbstractDigraph;
import se.artheus.floyd4j.Dependency;
import se.artheus.floyd4j.Edge;

public class DependencyDigraph extends AbstractDigraph<Dependency> {
  public DependencyDigraph(DependencyEdge... edges) {
    super((Edge[]) edges);
  }

  public DependencyDigraph(int size) {
    super(size);
  }
}
