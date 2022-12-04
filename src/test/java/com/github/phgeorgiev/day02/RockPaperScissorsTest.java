package com.github.phgeorgiev.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest {

  static String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day02/input.txt"));
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
