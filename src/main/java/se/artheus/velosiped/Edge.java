package se.artheus.velosiped;

/**
 * Digraph edge
 *
 * @param <T> Tail vertex type
 * @param <H> Head vertex type
 */
public interface Edge<T extends Vertex, H extends Vertex> {

  /**
   * Getter for the tail vertex
   *
   * @return {@link T}
   */
  T tail();

  /**
   * Getter for the head vertex
   *
   * @return {@link H}
   */
  H head();
}
