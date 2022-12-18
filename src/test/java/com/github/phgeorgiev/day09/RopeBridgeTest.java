package com.github.phgeorgiev.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class RopeBridgeTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 9;
  }

  @Test
  void shouldFindPositionsCountTailVisited() {
    String input = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
        """;

    assertEquals(13, new RopeBridge(input, 2).tailPositionsCount());
  }

  @Test
  void shouldFindPositionsCountTailVisitedFromInput() throws IOException {
    assertEquals(6236, new RopeBridge(input(), 2).tailPositionsCount());
  }

  @Test
  void shouldFindPositionsCountTailVisitedForLongerRope() {
    String input = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
        """;

    assertEquals(1, new RopeBridge(input, 10).tailPositionsCount());
  }

  @Test
  void shouldFindPositionsCountTailVisitedFromInputForLongerRope() throws IOException {
    assertEquals(2449, new RopeBridge(input(), 10).tailPositionsCount());
  }
}
