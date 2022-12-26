package com.github.phgeorgiev.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class HillClimbingAlgorithmTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 12;
  }

  @Test
  void shouldFindPathToPeak() {
    String input = """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
        """;

    assertEquals(29, new HillClimb(input).findFewestStepsPath());
  }

  @Test
  void shouldFindPathToPeakFromInput() throws IOException {
    assertEquals(443, new HillClimb(input()).findFewestStepsPath());
  }
}
