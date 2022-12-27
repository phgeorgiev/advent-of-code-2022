package com.github.phgeorgiev.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public class DistressSignal {

  private final List<Pair> pairs;

  public DistressSignal(String packets) {
    pairs = Arrays.stream(packets.split("\n\n")).map(stringPairs -> {
      String[] lines = stringPairs.split("\n");
      return new Pair(new JSONArray(lines[0]).toList(), new JSONArray(lines[1]).toList());
    }).toList();
  }

  public int sumRightOrderedSignals() {
    int indicesSum = 0;
    for (int i = 0; i < pairs.size(); i++) {
      if (compareSignals(pairs.get(i).left(), pairs.get(i).right()) <= 0) {
        indicesSum += i + 1;
      }
    }

    return indicesSum;
  }

  public int findDecoderKey() {
    List<Pair> newList = new ArrayList<>(pairs);
    List<Object> dividerPacket1 = List.of(List.of(2));
    List<Object> dividerPacket2 = List.of(List.of(6));
    newList.add(new Pair(dividerPacket1, dividerPacket2));
    List<List<Object>> packets = new ArrayList<>();
    for (Pair pair : newList) {
      packets.add(pair.left());
      packets.add(pair.right());
    }

    packets.sort(this::compareSignals);

    return (packets.indexOf(dividerPacket1) + 1) * (packets.indexOf(dividerPacket2) + 1);
  }

  private int compareSignals(List<Object> left, List<Object> right) {
    for (int i = 0; i < left.size(); i++) {
      if (i >= right.size()) {
        return 1;
      }

      var leftValue = left.get(i);
      var rightValue = right.get(i);

      if (leftValue instanceof Integer && rightValue instanceof Integer) {
        int compare = Integer.compare((int) leftValue, (int) rightValue);
        if (compare == 0) {
          continue;
        } else {
          return compare;
        }
      }

      if (leftValue instanceof List<?> && rightValue instanceof List<?>) {
        int compareSignals = compareSignals((List<Object>) leftValue, (List<Object>) rightValue);
        if (compareSignals != 0) {
          return compareSignals;
        }
      }

      if (leftValue instanceof Integer && rightValue instanceof List<?>) {
        int compareSignals = compareSignals(List.of(leftValue), (List<Object>) rightValue);
        if (compareSignals != 0) {
          return compareSignals;
        }
      }

      if (leftValue instanceof List<?> && rightValue instanceof Integer) {
        int compareSignals = compareSignals((List<Object>) leftValue, List.of(rightValue));
        if (compareSignals != 0) {
          return compareSignals;
        }
      }
    }

    return Integer.compare(left.size(), right.size());
  }

  record Pair(List<Object> left, List<Object> right) { }
}
