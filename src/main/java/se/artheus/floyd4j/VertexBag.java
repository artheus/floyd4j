package se.artheus.floyd4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VertexBag implements Iterable<Vertex>  {
  private Node<Vertex> first;
  private int size;

  public VertexBag() {
    first = null;
    size = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public Iterator<Vertex> iterator()  {
    return new BagIterator<Vertex>(first);
  }

  public void add(Vertex item) {
    Node<Vertex> oldfirst = first;
    first = new Node<Vertex>();
    first.item = item;
    first.next = oldfirst;
    size++;
  }

  private static class Node<T> {
    private T item;
    private Node<T> next;
  }

  private static class BagIterator<T> implements Iterator<T> {
    private Node<T> current;

    BagIterator(Node<T> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public T next() {
      if (!hasNext()) throw new NoSuchElementException();
      T item = current.item;
      current = current.next;
      return item;
    }
  }
}
