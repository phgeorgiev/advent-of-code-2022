package com.github.phgeorgiev.day02;

public class Round {

  private final Shape opponent;
  private final Shape me;

  public Round(char opponent, char me) {
    this.opponent = Decryptor.decryptShape(opponent);
    this.me = Outcome.calculateMyShape(this.opponent, me);
  }

  public int calculate() {
    int result = outcome();
    switch (me) {
      case ROCK -> result += 1;
      case PAPER -> result += 2;
      case SCISSORS -> result += 3;
    }

    return result;
  }

  private int outcome() {
    if (opponent == me) {
      return 3;
    }

    if (me == Shape.ROCK) {
      return opponent == Shape.SCISSORS ? 6 : 0;
    }

    if (me == Shape.SCISSORS) {
      return opponent == Shape.PAPER ? 6 : 0;
    }

    return opponent == Shape.ROCK ? 6 : 0;
  }
}
