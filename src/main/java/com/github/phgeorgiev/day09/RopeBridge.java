package com.github.phgeorgiev.day09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RopeBridge {

  private final Set<String> tailUniqueMoves;
  private final List<Position> rope;
  private final String[] motions;

  public RopeBridge(String input, int ropeSize) {
    rope = new LinkedList<>();
    tailUniqueMoves = new HashSet<>();
    for (int i = 0; i < ropeSize; i++) {
      rope.add(new Position(0, 0));
    }
    tailUniqueMoves.add(rope.get(1).toString());

    motions = input.split("\n");
  }

  public int tailPositionsCount() {
    Arrays.stream(motions).forEach(line -> {
      String direction = line.split(" ")[0];
      int steps = Integer.parseInt(line.split(" ")[1]);

      Position position;
      switch (direction) {
        case "R" -> position = new Position(1, 0);
        case "U" -> position = new Position(0, 1);
        case "D" -> position = new Position(0, -1);
        case "L" -> position = new Position(-1, 0);
        default -> position = new Position(0, 0);
      }

      for (int i = 0; i < steps; i++) {
        moveRope(position);
      }
    });

    return tailUniqueMoves.size();
  }

  private void moveRope(Position move) {
    Position head = rope.get(0);
    head.setX(head.x() + move.x());
    head.setY(head.y() + move.y());

    for (int i = 1; i < rope.size(); i++) {
      Position knot = rope.get(i);
      Position prevKnot = rope.get(i - 1);
      if (prevKnot.equals(knot)) {
        break;
      }

      if (Math.abs(prevKnot.x() - knot.x()) <= 1 && Math.abs(prevKnot.y() - knot.y()) <= 1
          && Math.abs((prevKnot.x() - knot.x()) * (prevKnot.y() - knot.y())) <= 1) {
        break;
      }

      knot.setX(knot.x() + Integer.compare(prevKnot.x() - knot.x(), 0));
      knot.setY(knot.y() + Integer.compare(prevKnot.y() - knot.y(), 0));

      if (i == rope.size() - 1) {
        tailUniqueMoves.add(knot.toString());
      }
    }
  }
}
