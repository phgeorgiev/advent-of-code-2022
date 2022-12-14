package com.github.phgeorgiev.day08;

public class VisibleHouseChecker {

  private final char[][] grid;

  private final int[][] directions = {
      { -1, 0 },
      { 0, 1 },
      { 1, 0 },
      { 0, -1 },
  };

  public VisibleHouseChecker(String grid) {
    String[] split = grid.split("\n");
    this.grid = new char[split.length][];
    for (int i = 0; i < split.length; i++) {
      this.grid[i] = split[i].toCharArray();
    }
  }

  public int getVisibleHouseCount() {
    int highestScenicScore = 1;
    int tempHighestScenicScore = 1;
    for (int y = 1; y < grid.length - 1; y++) {
      for (int x = 1; x < grid[y].length - 1; x++) {
        for (int[] direction: directions) {
          tempHighestScenicScore *= check(direction, x, y, grid[y][x]);
        }

        if (tempHighestScenicScore > highestScenicScore) {
          highestScenicScore = tempHighestScenicScore;
        }

        tempHighestScenicScore = 1;
      }
    }

    return highestScenicScore;
  }

  private int check(int[] direction, int x, int y, char tree) {
    int nextX = x + direction[1];
    int nextY = y + direction[0];
    if (isOutsideGrid(nextX, nextY)) {
      return 0;
    }

    if (tree <= grid[nextY][nextX]) {
      return 1;
    }

    return check(direction, nextX, nextY, tree) + 1;
  }

  private boolean isOutsideGrid(int x,  int y) {
    return (y < 0 || y >= grid.length) || (x < 0 || x >= grid[0].length);
  }
}
