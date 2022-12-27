package com.github.phgeorgiev.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class RegolithReservoirTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 14;
  }

  @Test
  void shouldFindRestingSandsCount() {
    String input = """
        498,4 -> 498,6 -> 496,6
        503,4 -> 502,4 -> 502,9 -> 494,9
        """;

    assertEquals(24, new RegolithReservoir(input).getRestingSandsCount());
  }

  @Test
  void shouldFindRestingSandsCountFromInput() throws IOException {
    assertEquals(994, new RegolithReservoir(input()).getRestingSandsCount());
  }
}
