package com.github.phgeorgiev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

abstract public class BaseTestUtils {

  abstract protected Integer getDay();

  public String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day%02d/input.txt".formatted(getDay())));
  }
}
