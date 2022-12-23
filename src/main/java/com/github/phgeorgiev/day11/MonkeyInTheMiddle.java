package com.github.phgeorgiev.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MonkeyInTheMiddle {

  protected final List<Monkey> monkeys = new ArrayList<>();

  public MonkeyInTheMiddle(String input) {
    for (String monkey : input.split("\n\n")) {
      Deque<Long> items = null;
      Operation operation = null;
      int divisible = 0;
      int trueMonkeyNumber = 0;
      int falseMonkeyNumber = 0;

      for (String line : monkey.split("\n")) {
        if (line.contains("Starting items:")) {
          items = Pattern
              .compile("(\\d+)")
              .matcher(line)
              .results()
              .map(MatchResult::group)
              .map(Long::parseLong)
              .collect(Collectors.toCollection(LinkedList::new));
        }

        if (line.contains("Operation:")) {
          operation = new Operation(line.split("=")[1].trim());
        }

        if (line.contains("Test:")) {
          Matcher matcher = Pattern.compile("(\\d+)").matcher(line);
          if (matcher.find()) {
            divisible = Integer.parseInt(matcher.group(1));
          }
        }

        if (line.contains("If true:")) {
          Matcher matcher = Pattern.compile("(\\d+)").matcher(line);
          if (matcher.find()) {
            trueMonkeyNumber = Integer.parseInt(matcher.group(1));
          }
        }

        if (line.contains("If false:")) {
          Matcher matcher = Pattern.compile("(\\d+)").matcher(line);
          if (matcher.find()) {
            falseMonkeyNumber = Integer.parseInt(matcher.group(1));
          }
        }
      }

      monkeys.add(new Monkey(items, operation, new Test(divisible, trueMonkeyNumber, falseMonkeyNumber)));
    }
  }

  public long getMonkeyBusiness() {
    for (int i = 0; i < 20; i++) {
      monkeys.forEach(Monkey::inspectItems);
    }

    return monkeys.stream()
        .map(Monkey::getInspectionCount)
        .sorted(Comparator.reverseOrder())
        .limit(2)
        .mapToInt(Integer::intValue)
        .reduce((arr, value) -> arr * value)
        .orElse(0);
  }

  class Monkey {

    private final Deque<Long> items;
    private final Operation operation;
    private final Test test;

    private int inspectionCount = 0;


    Monkey(
        Deque<Long> items,
        Operation operation,
        Test test
    ) {
      this.items = items;
      this.operation = operation;
      this.test = test;
    }

    public void addItem(Long item) {
      items.add(item);
    }

    public void inspectItems() {
      while (!items.isEmpty()) {
        Long item = items.pollFirst();
        if (item == null) {
          continue;
        }

        updateItemWorryLevel(item);
        inspectionCount++;
      }
    }

    private void updateItemWorryLevel(Long item) {
      long newWorryLevel = operation.calculate(item) / 3;
      monkeys.get(test.getNextMonkey(newWorryLevel)).addItem(newWorryLevel);
    }

    public int getInspectionCount() {
      return inspectionCount;
    }
  }
}
