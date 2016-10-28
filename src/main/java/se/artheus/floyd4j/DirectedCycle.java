package se.artheus.floyd4j;

import java.util.Arrays;

public class DirectedCycle {

  private boolean[] marked;        // marked[v] = has vertex v been marked?
  private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
  private boolean[] onStack;       // onStack[v] = is vertex on the stack?
  private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

  /**
   * Determines whether the digraph {@code G} has a directed cycle and, if so,
   * finds such a cycle.
   *
   * @param digraph the digraph
   */
  public DirectedCycle(Digraph digraph) {
    marked = new boolean[digraph.size()];
    onStack = new boolean[digraph.size()];
    edgeTo = new int[digraph.size()];
    for (int v = 0; v < digraph.size(); v++)
      if (!marked[v] && cycle == null) dfs(digraph, v);
  }

  // check that algorithm computes either the topological order or finds a directed cycle
  private void dfs(Digraph G, int v) {
    onStack[v] = true;
    marked[v] = true;
    for (Object wo : G.adj(v)) {
      Vertex w = (Vertex) wo;

      // short circuit if directed cycle found
      if (cycle != null) return;

        // found new vertex, so recur
      else if (!marked[w.index()]) {
        edgeTo[w.index()] = v;
        dfs(G, w.index());
      }

      // trace back directed cycle
      else if (onStack[w.index()]) {
        cycle = new Stack<Integer>();
        for (int x = v; x != w.index(); x = edgeTo[x]) {
          cycle.push(x);
        }
        cycle.push(w.index());
        cycle.push(v);
        assert check();
      }
    }
    onStack[v] = false;
  }

  /**
   * Does the digraph have a directed cycle?
   *
   * @return {@code true} if the digraph has a directed cycle, {@code false} otherwise
   */
  public boolean hasCycle() {
    return cycle != null;
  }

  /**
   * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
   *
   * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
   * and {@code null} otherwise
   */
  public Iterable<Integer> cycle() {
    return cycle;
  }


  // certify that digraph has a directed cycle if it reports one
  private boolean check() {

    if (hasCycle()) {
      // verify cycle
      int first = -1, last = -1;
      for (int v : cycle()) {
        if (first == -1) first = v;
        last = v;
      }
      if (first != last) {
        System.err.printf("cycle begins with %d and ends with %d\n", first, last);
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return "DirectedCycle{" +
            "marked=" + Arrays.toString(marked) +
            ", edgeTo=" + Arrays.toString(edgeTo) +
            ", onStack=" + Arrays.toString(onStack) +
            ", cycle=" + cycle +
            '}';
  }
}
