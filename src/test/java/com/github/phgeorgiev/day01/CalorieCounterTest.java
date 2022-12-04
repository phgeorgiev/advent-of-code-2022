package com.github.phgeorgiev.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class CalorieCounterTest {

  static String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day01/input.txt"));
  }

  @Test
  void calculateCalories() {
    assertEquals(11000, new CalorieCounter("""
        5000
        6000
        """).findMostCaloriesElf());
  }

  @Test
  void calculateMultipleElves() {
    assertEquals(24000, new CalorieCounter("""
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
        """).findMostCaloriesElf());
  }

  @Test
  void calculateTop3Elves() {
    assertEquals(45000, new CalorieCounter("""
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
        """).findTopThreeElvesSum());
  }

  @Test
  void findElfCarryingTheMostCalories() throws IOException {
    assertEquals(72070, new CalorieCounter(input()).findMostCaloriesElf());
  }

  @Test
  void findTopThreeElvesCarryingTheMostCalories() throws IOException {
    assertEquals(211805, new CalorieCounter(input()).findTopThreeElvesSum());
  }
}
