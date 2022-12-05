package com.github.phgeorgiev.day04;

import java.util.Arrays;
import java.util.List;

public class SectionPair {

  private final List<Pair> pairList;

  public SectionPair(String pairs) {
    pairList = Arrays.stream(pairs.split("\n")).map(Pair::new).toList();
  }

  public int getFullyOverlappingPairsCount() {
    return pairList.stream()
        .filter(Pair::isFullyOverlapping)
        .mapToInt(s -> 1)
        .sum();
  }

  public int getPartiallyOverlappingPairsCount() {
    return pairList.stream()
        .filter(Pair::isPartiallyOverlapping)
        .mapToInt(s -> 1)
        .sum();
  }
}

