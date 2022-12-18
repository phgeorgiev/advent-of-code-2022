package com.github.phgeorgiev.day09;

final class Position {

  private int x;
  private int y;

  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Position[" + "x=" + x + ", " + "y=" + y + ']';
  }
}
