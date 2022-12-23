package com.github.phgeorgiev.day11;

public class Operation {

  private final String operation;

  public Operation(String operation) {
    this.operation = operation;
  }

  public long calculate(long value) {
    if (operation.contains("*")) {
      String multiplyBy = operation.split("\\*")[1];
      if (multiplyBy.contains("old")) {
        return value * value;
      } else {
        return value * Long.parseLong(multiplyBy.trim());
      }
    } else {
      String addWith = operation.split("\\+")[1];
      if (addWith.contains("old")) {
        return value + value;
      } else {
        return value + Long.parseLong(addWith.trim());
      }
    }
  }
}
