package com.github.phgeorgiev.day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StackRearranger {

  private final List<Deque<Character>> stackList = new ArrayList<>();
  private final Deque<Move> moves = new ArrayDeque<>();

  public StackRearranger(String stacks) {
    String[] parts = stacks.split("\n\n");

    String[] lines = parts[0].split("\n");
    String lastLine =  lines[lines.length - 1];
    int stackCount = Integer.parseInt(lastLine.substring(lastLine.length() - 1));
    for (int i = 0; i < stackCount; i++) {
      stackList.add(new ArrayDeque<>());
    }

    Arrays.stream(lines)
        .forEach(line -> {
          Pattern.compile("([A-Z])")
              .matcher(line)
              .results()
              .map(MatchResult::start)
              .forEach(position -> {
                stackList
                    .get(Character.getNumericValue(lastLine.charAt(position)) - 1)
                    .add(line.charAt(position));
              });
        });

    Arrays.stream(parts[1].split("\n"))
        .forEach(line -> {
          List<Integer> collect = Pattern.compile("(\\d+)")
              .matcher(line)
              .results()
              .map(MatchResult::group)
              .map(Integer::valueOf)
              .toList();

          moves.add(new Move(collect.get(0), collect.get(1) - 1, collect.get(2) - 1));
        });
  }

  public String rearrange() {
    moves.forEach(move -> {
      Deque<Character> temp = new ArrayDeque<>();
      for (int i = 0; i < move.crates(); i++) {
        temp.push(stackList.get(move.fromStack()).pop());
      }
      for (int i = 0; i < move.crates(); i++) {
        stackList
            .get(move.toStack())
            .push(temp.pop());
      }
    });

    return stackList.stream()
        .map(Deque::pop)
        .map(String::valueOf)
        .collect(Collectors.joining(""));
  }
}
