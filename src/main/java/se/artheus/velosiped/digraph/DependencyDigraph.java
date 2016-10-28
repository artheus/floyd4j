package se.artheus.velosiped.digraph;

import se.artheus.velosiped.AbstractDigraph;
import se.artheus.velosiped.Dependency;
import se.artheus.velosiped.Edge;

public class DependencyDigraph extends AbstractDigraph<Dependency> {
  public DependencyDigraph(DependencyEdge... edges) {
    super((Edge[]) edges);
  }

  public DependencyDigraph(int size) {
    super(size);
  }
}
