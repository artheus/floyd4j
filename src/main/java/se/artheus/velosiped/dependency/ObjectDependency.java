package se.artheus.velosiped.dependency;

import se.artheus.velosiped.AbstractDependency;

public class ObjectDependency extends AbstractDependency<Object> {
  public ObjectDependency(int index, Object value) {
    super(index, value);
  }

  public ObjectDependency(Object value) {
    super(value);
  }
}
