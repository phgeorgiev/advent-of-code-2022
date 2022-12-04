package com.github.phgeorgiev.day01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CalorieCounter {

  private final List<Integer> elves;

  public CalorieCounter(String input) {
    elves = Arrays.stream(input.split("\n\n"))
        .map(CalorieCounter::elfCalories)
        .toList();
  }

  private static int elfCalories(String elf) {
    return Arrays.stream(elf.split("\n")).mapToInt(Integer::valueOf).sum();
  }

  public int findMostCaloriesElf() {
    return elves.stream()
        .mapToInt(x -> x)
        .max()
        .orElseThrow();
  }

  public int findTopThreeElvesSum() {
    return elves.stream()
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .mapToInt(Integer::valueOf)
        .sum();
  }
}
