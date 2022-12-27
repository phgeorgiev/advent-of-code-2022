package com.github.phgeorgiev.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.Range;

public class RegolithReservoir {

  private final Set<Point> sands = new HashSet<>();
  private final List<RocksLine> rocks;

  private int lowestRock = 0;

  public RegolithReservoir(String input) {
    rocks = Arrays.stream(input.split("\n"))
        .map(line -> {
          String[] coordinates = line.split("->");
          List<RocksLine> lineRocks = new ArrayList<>();
          for (int i = 0; i < coordinates.length - 1; i++) {
            String[] start = coordinates[i].trim().split(",");
            String[] end = coordinates[i + 1].trim().split(",");

            lineRocks.add(new RocksLine(
                    new Point(Integer.parseInt(start[0]), Integer.parseInt(start[1])),
                    new Point(Integer.parseInt(end[0]), Integer.parseInt(end[1]))
                )
            );

            if (lowestRock < Integer.parseInt(start[1])) {
              lowestRock = Integer.parseInt(start[1]);
            }

            if (lowestRock < Integer.parseInt(end[1])) {
              lowestRock = Integer.parseInt(end[1]);
            }
          }

          return lineRocks;
        })
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public int getRestingSandsCount() {
    int counter = 0;
    while (dropSand()) {
      counter++;
    }

    return counter;
  }

  private boolean dropSand() {
    int x = 500;
    int y = 0;

    while (true) {
      if (y > lowestRock) {
        return false;
      }

      if (isNextPositionFree(x, y + 1)) {
        y++;
        continue;
      }

      if (isNextPositionFree(x - 1, y + 1)) {
        x -= 1;
        continue;
      }

      if (isNextPositionFree(x + 1, y + 1)) {
        x += 1;
        continue;
      }

      sands.add(new Point(x, y));
      return true;
    }
  }

  private boolean isNextPositionFree(int x, int y) {
    if (sands.contains(new Point(x, y))) {
      return false;
    }

    for (RocksLine rocksLine : rocks) {
      if (Range.between(rocksLine.start().x(), rocksLine.end().x()).contains(x)
          && Range.between(rocksLine.start().y(), rocksLine.end().y()).contains(y)) {
        return false;
      }
    }

    return true;
  }

  record Point(int x, int y) { }

  record RocksLine(Point start, Point end) { }
}
