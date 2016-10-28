package se.artheus.floyd4j.dependency;

import se.artheus.floyd4j.AbstractDependency;

public class IntegerDependency extends AbstractDependency<Integer> {
  public IntegerDependency(int index, Integer value) {
    super(index, value);
  }

  public IntegerDependency(Integer value) {
    super(value);
  }
}
