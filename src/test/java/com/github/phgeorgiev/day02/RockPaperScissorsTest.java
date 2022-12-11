package com.github.phgeorgiev.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest extends BaseTestUtils {

  protected Integer getDay() {
    return 2;
  }

  @Test
  void calculateRoundScore() {
    assertEquals(4, new Round('A', 'Y').calculate());
    assertEquals(1, new Round('B', 'X').calculate());
    assertEquals(7, new Round('C', 'Z').calculate());
  }

  @Test
  void calculateTotalScore() {
    assertEquals(12, new RockPaperScissorsTournament("""
        A Y
        B X
        C Z
        """).totalScore());
  }

  @Test
  void calculateTotalScoreFromInput() throws IOException {
    assertEquals(13889, new RockPaperScissorsTournament(input()).totalScore());
  }
}
