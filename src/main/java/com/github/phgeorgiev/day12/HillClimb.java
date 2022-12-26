package com.github.phgeorgiev.day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HillClimb {

  private final int[][] directions = {
      {0, 1},
      {-1, 0},
      {0, -1},
      {1, 0},
  };

  private final Node[][] maze;
  private List<Node> openList = new ArrayList<>();
  private List<Node> closedList = new ArrayList<>();
  private final List<Node> startingPositions = new ArrayList<>();
  private Node target;

  public HillClimb(String inputMaze) {
    String[] rows = inputMaze.split("\n");
    maze = new Node[rows.length][rows[0].length()];
    for (int y = 0; y < rows.length; y++) {
      for (int x = 0; x < rows[y].length(); x++) {
        maze[y][x] = new Node(x, y, rows[y].charAt(x));
        if (rows[y].charAt(x) == 'S') {
          maze[y][x] = new Node(x, y, 'a');
        }

        if (rows[y].charAt(x) == 'E') {
          maze[y][x] = new Node(x, y, 'z');
          target = maze[y][x];
        }

        if (rows[y].charAt(x) == 'S' || rows[y].charAt(x) == 'a') {
          startingPositions.add(maze[y][x]);
        }
      }
    }

    for (int y = 0; y < maze.length; y++) {
      for (int x = 0; x < maze[0].length; x++) {
        Node node = maze[y][x];
        node.setNeighbors(getNeighbors(x, y));
        if (maze[y][x].getHeight() == 'S') {
          openList.add(node);
        }

        if (maze[y][x].getHeight() == 'E') {
          target = node;
        }
      }
    }
  }

  public int findFewestStepsPath() {
    int shortest = Integer.MAX_VALUE;
    for (Node start : startingPositions) {
      for (Node[] nodes : maze) {
        for (int i = 0; i < maze[0].length; i++) {
          nodes[i].setH(0);
          nodes[i].setG(0);
          nodes[i].setF(0);
        }
      }

      openList = new ArrayList<>() {{
        add(start);
      }};
      closedList = new ArrayList<>();

      if (findPath() && target.getG() < shortest) {
        shortest = target.getG();
      }
    }

    return shortest;
  }

  private boolean findPath() {
    Node start = openList.get(0);
    start.setH(calculateHeuristic(start, target));
    start.setF(start.getG() + start.getH());

    while (!openList.isEmpty()) {
      Node current = openList.get(0);
      for (int i = 1; i < openList.size(); i++) {
        if (openList.get(i).getF() < current.getF()) {
          current = openList.get(i);
        }
      }

      if (current.equals(target)) {
        return true;
      }

      openList.remove(current);
      closedList.add(current);
      for (Node neighbor : current.getNeighbors()) {
        if (closedList.contains(neighbor)) {
          continue;
        }

        int tempG = current.getG() + 1;
        if (openList.contains(neighbor)) {
          if (tempG < neighbor.getG()) {
            neighbor.setG(tempG);
          }
        } else {
          neighbor.setG(tempG);
          openList.add(neighbor);
        }

        neighbor.setH(calculateHeuristic(neighbor, target));
        neighbor.setF(neighbor.getG() + neighbor.getH());
      }
    }

    return false;
  }

  private int calculateHeuristic(Node a, Node b) {
    int dx = Math.abs(a.getX() - b.getX());
    int dy = Math.abs(a.getY() - b.getY());
    return dx + dy;
  }

  private List<Node> getNeighbors(int x, int y) {
    List<Node> neighbors = new LinkedList<>();

    for (int[] direction : directions) {
      int nextX = x + direction[1];
      int nextY = y + direction[0];

      if (nextX < 0 || nextX >= maze[0].length || nextY < 0 || nextY >= maze.length) {
        continue;
      }

      if (maze[nextY][nextX].getHeight() - maze[y][x].getHeight() <= 1) {
        neighbors.add(maze[nextY][nextX]);
      }
    }

    return neighbors;
  }
}
