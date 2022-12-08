package com.github.phgeorgiev.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class SupplyStacksTest {

  static String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day05/input.txt"));
  }

  @Test
  void rearrangeStack() {
    assertEquals("MCD", new StackRearranger("""
            [D]
        [N] [C]
        [Z] [M] [P]
         1   2   3
                
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
        """).rearrange());
  }

  @Test
  void rearrangeStackFromInput() throws IOException {
    assertEquals("LCTQFBVZV", new StackRearranger(input()).rearrange());
  }
}
