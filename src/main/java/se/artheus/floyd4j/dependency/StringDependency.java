package se.artheus.floyd4j.dependency;

import se.artheus.floyd4j.AbstractDependency;

public class StringDependency extends AbstractDependency<String> {
  public StringDependency(int index, String value) {
    super(index, value);
  }

  public StringDependency(String value) {
    super(value);
  }
}
