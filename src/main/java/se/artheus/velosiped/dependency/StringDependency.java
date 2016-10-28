package se.artheus.velosiped.dependency;

import se.artheus.velosiped.AbstractDependency;

public class StringDependency extends AbstractDependency<String> {
  public StringDependency(int index, String value) {
    super(index, value);
  }

  public StringDependency(String value) {
    super(value);
  }
}
