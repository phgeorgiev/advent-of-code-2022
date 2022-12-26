package com.github.phgeorgiev.day12;

import java.util.ArrayList;
import java.util.List;

public final class Node {

  private final int x;
  private final int y;
  private final int height;
  private List<Node> neighbors;
  private int f = 0;
  private int g = 1;
  private int h = 0;

  public Node(int x, int y, int height) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.neighbors = new ArrayList<>();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getHeight() {
    return height;
  }

  public int getF() {
    return f;
  }

  public void setF(int f) {
    this.f = f;
  }

  public int getG() {
    return g;
  }

  public void setG(int g) {
    this.g = g;
  }

  public int getH() {
    return h;
  }

  public void setH(int h) {
    this.h = h;
  }

  public List<Node> getNeighbors() {
    return neighbors;
  }

  public void setNeighbors(List<Node> neighbors) {
    this.neighbors = neighbors;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    var that = (Node) obj;
    return this.x == that.x && this.y == that.y;
  }
}
