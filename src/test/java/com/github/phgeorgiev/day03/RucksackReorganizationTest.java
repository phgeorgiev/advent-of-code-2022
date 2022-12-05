package com.github.phgeorgiev.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class RucksackReorganizationTest {

  static String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day03/input.txt"));
  }

  @Test
  void getRucksacksPriority() {
    assertEquals(16, new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp").getPriorityRearrangement());
    assertEquals(38, new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL").getPriorityRearrangement());
    assertEquals(22, new Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn").getPriorityRearrangement());
    assertEquals(20, new Rucksack("ttgJtRGJQctTZtZT").getPriorityRearrangement());
    assertEquals(19, new Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw").getPriorityRearrangement());
  }

  @Test
  void calculatePriorityRearrangementSum() {
    assertEquals(157, new RucksacksRearranger("""
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
        """).getPriorityRearrangementSum());
  }

  @Test
  void calculatePriorityRearrangementSumFromInput() throws IOException {
    assertEquals(8185, new RucksacksRearranger(input()).getPriorityRearrangementSum());
  }

  @Test
  void calculateBadgePriorityRearrangementSum() {
    assertEquals(70, new RucksacksRearranger("""
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
        """).getBadgePriorityRearrangementSum());
  }

  @Test
  void calculateBadgePriorityRearrangementSumFromInput() throws IOException {
    assertEquals(2817, new RucksacksRearranger(input()).getBadgePriorityRearrangementSum());
  }
}
