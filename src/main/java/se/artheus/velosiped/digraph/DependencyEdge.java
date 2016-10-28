package se.artheus.velosiped.digraph;

import se.artheus.velosiped.Dependency;
import se.artheus.velosiped.Edge;

public class DependencyEdge implements Edge<Dependency, Dependency> {

  private final Dependency tail;
  private final Dependency head;

  public DependencyEdge(Dependency tail, Dependency head) {
    this.tail = tail;
    this.head = head;
  }

  public Dependency tail() {
    return tail;
  }

  public Dependency head() {
    return head;
  }
}
