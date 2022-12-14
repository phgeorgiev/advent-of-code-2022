package com.github.phgeorgiev.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class CampCleanupTest extends BaseTestUtils {

  protected Integer getDay() {
    return 4;
  }

  @Test
  void calculatePairsFullyContainTheOrder() {
    assertEquals(2, new SectionPair("""
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
        """).getFullyOverlappingPairsCount());
  }

  @Test
  void calculatePairsPartiallyContainTheOrder() {
    assertEquals(4, new SectionPair("""
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
        """).getPartiallyOverlappingPairsCount());
  }

  @Test
  void calculatePairsFullyContainTheOrderFromInput() throws IOException {
    assertEquals(530, new SectionPair(input()).getFullyOverlappingPairsCount());
  }

  @Test
  void calculatePairsPartiallyContainTheOrderFromInput() throws IOException {
    assertEquals(903, new SectionPair(input()).getPartiallyOverlappingPairsCount());
  }
}
