package com.github.phgeorgiev.day04;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.Range;

public class Pair {

  private final List<Range<Integer>> ranges;

  public Pair(String pair) {
    ranges = Arrays.stream(pair.split(","))
        .map(s -> Arrays.stream(s.split("-")).mapToInt(Integer::valueOf).toArray())
        .map(s -> Range.between(s[0], s[1]))
        .toList();
  }

  public boolean isFullyOverlapping() {
    return ranges.get(0).containsRange(ranges.get(1)) || ranges.get(1).containsRange(ranges.get(0));
  }

  public boolean isPartiallyOverlapping() {
    return ranges.get(0).isOverlappedBy(ranges.get(1)) || ranges.get(1).isOverlappedBy(ranges.get(0));
  }
}
