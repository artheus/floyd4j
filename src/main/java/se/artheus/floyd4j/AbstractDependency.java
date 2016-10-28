package se.artheus.floyd4j;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDependency<T> implements Dependency<T> {

  private T value;
  private int index;

  public AbstractDependency() {
    this(-1, null);
  }

  public AbstractDependency(T value) {
    this(-1, value);
  }

  public AbstractDependency(int index, T value) {
    this.index = index;
    this.value = value;
  }

  public void index(int index) {
    this.index = index;
  }

  public int index() {
    return index;
  }

  public T get() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractDependency<?> that = (AbstractDependency<?>) o;

    return value != null ? value.equals(that.value) : that.value == null;

  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "AbstractDependency{" +
            "value=" + value +
            ", index=" + index +
            '}';
  }
}
