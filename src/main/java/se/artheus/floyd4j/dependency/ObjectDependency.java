package se.artheus.floyd4j.dependency;

import se.artheus.floyd4j.AbstractDependency;

public class ObjectDependency extends AbstractDependency<Object> {
  public ObjectDependency(int index, Object value) {
    super(index, value);
  }

  public ObjectDependency(Object value) {
    super(value);
  }
}
