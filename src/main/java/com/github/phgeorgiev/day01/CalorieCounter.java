package com.github.phgeorgiev.day01;

import java.util.Arrays;

public class CalorieCounter {

  private final String[] elves;

  public CalorieCounter(String input) {
    elves = input.split("\n\n");
  }

  private static int elfCalories(String elf) {
    return Arrays.stream(elf.split("\n")).mapToInt(Integer::valueOf).sum();
  }

  public int findMostCalories() {
    return Arrays.stream(elves).map(CalorieCounter::elfCalories).mapToInt(x -> x).max()
        .orElseThrow();
  }
}
