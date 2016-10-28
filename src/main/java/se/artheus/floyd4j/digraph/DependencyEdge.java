package se.artheus.floyd4j.digraph;

import se.artheus.floyd4j.Dependency;
import se.artheus.floyd4j.Edge;

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
