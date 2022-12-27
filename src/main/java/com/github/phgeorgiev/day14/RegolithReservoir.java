package com.github.phgeorgiev.day14;

import java.util.Arrays;
import org.apache.commons.lang3.Range;

public class RegolithReservoir {

  private final boolean[][] visited;

  private int lowestRock = 0;

  public RegolithReservoir(String input) {
    visited = new boolean[1_000][1_000];
    Arrays.stream(input.split("\n"))
        .forEach(line -> {
          String[] coordinates = line.split("->");
          for (int i = 0; i < coordinates.length - 1; i++) {
            String[] start = coordinates[i].trim().split(",");
            String[] end = coordinates[i + 1].trim().split(",");

            Range<Integer> xRange = Range.between(Integer.parseInt(start[0]), Integer.parseInt(end[0]));
            Range<Integer> yRange = Range.between(Integer.parseInt(start[1]), Integer.parseInt(end[1]));

            for (int y = yRange.getMinimum(); y <= yRange.getMaximum(); y++) {
              for (int x = xRange.getMinimum(); x <= xRange.getMaximum(); x++) {
                visited[y][x] = true;
              }
            }

            if (lowestRock < Integer.parseInt(start[1])) {
              lowestRock = Integer.parseInt(start[1]);
            }

            if (lowestRock < Integer.parseInt(end[1])) {
              lowestRock = Integer.parseInt(end[1]);
            }
          }
        });

    for (int x = 0; x < visited[0].length; x++) {
      visited[lowestRock + 2][x] = true;
    }
  }

  public int getRestingSandsCount(boolean hasFloor) {
    int counter = 0;
    while (dropSand(hasFloor)) {
      counter++;
    }

    return counter;
  }

  private boolean dropSand(boolean hasFloor) {
    int x = 500;
    int y = 0;

    if (visited[y][x]) {
      return false;
    }

    while (true) {
      if (!hasFloor && y > lowestRock) {
        return false;
      }

      if (!visited[y + 1][x]) {
        y++;
        continue;
      }

      if (!visited[y + 1][x - 1]) {
        x -= 1;
        continue;
      }

      if (!visited[y + 1][x + 1]) {
        x += 1;
        continue;
      }

      visited[y][x] = true;
      return true;
    }
  }
}
