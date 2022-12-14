package com.github.phgeorgiev.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class TreetopTreeHouseTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 8;
  }

  @Test
  void shouldFindHighestScenicScoreTree() {
    String input = """
        30373
        25512
        65332
        33549
        35390
        """;

    assertEquals(8, new VisibleHouseChecker(input).getVisibleHouseCount());
  }

  @Test
  void shouldFindHighestScenicScoreTreeFromInput() throws IOException {
    assertEquals(392080, new VisibleHouseChecker(input()).getVisibleHouseCount());
  }
}
