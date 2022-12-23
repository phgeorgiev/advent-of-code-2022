package com.github.phgeorgiev.day11;

public class Test {

  private final int divisible;
  private final int trueMonkeyNumber;
  private final int falseMonkeyNumber;

  public Test(int divisible, int trueMonkeyNumber, int falseMonkeyNumber) {
    this.divisible = divisible;
    this.trueMonkeyNumber = trueMonkeyNumber;
    this.falseMonkeyNumber = falseMonkeyNumber;
  }

  public int getNextMonkey(long item) {
    return item % divisible == 0 ? trueMonkeyNumber : falseMonkeyNumber;
  }
}
