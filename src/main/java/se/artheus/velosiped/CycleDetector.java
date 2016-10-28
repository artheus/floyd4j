package se.artheus.velosiped;

import se.artheus.velosiped.digraph.DependencyDigraph;

public class CycleDetector {

  /**
   * Detect cyclic dependencies in a flat dependency chain.
   *
   * @param digraph {@link DependencyDigraph}
   * @return {@link DirectedCycle} Object informing about cycles in {@link Digraph}
   */
  public DirectedCycle getDirectedCycle(DependencyDigraph digraph) {
    return new DirectedCycle(digraph);
  }
}
