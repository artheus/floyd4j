package se.artheus.velosiped.dependency;

import se.artheus.velosiped.AbstractDependency;

public class IntegerDependency extends AbstractDependency<Integer> {
  public IntegerDependency(int index, Integer value) {
    super(index, value);
  }

  public IntegerDependency(Integer value) {
    super(value);
  }
}
