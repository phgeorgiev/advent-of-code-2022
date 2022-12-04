package com.github.phgeorgiev.day02;

import java.util.Arrays;
import java.util.List;

public class RockPaperScissorsTournament {

  private final List<Round> rounds;

  public RockPaperScissorsTournament(String input) {
    rounds = Arrays.stream(input.split("\n"))
        .map(line -> new Round(line.charAt(0), line.charAt(2)))
        .toList();
  }

  public int totalScore() {
    return rounds.stream()
        .map(Round::calculate)
        .reduce(0, Integer::sum);
  }
}
