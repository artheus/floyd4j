package se.artheus.floyd4j;

public interface Vertex<T> {

  /**
   * @return int vertex index
   */
  int index();

  /**
   * Setter for index
   *
   * @param index int
   */
  void index(int index);

  /**
   * Get vertex value
   *
   * @return {@link T}
   */
  T get();
}
