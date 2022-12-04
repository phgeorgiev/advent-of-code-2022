package com.github.phgeorgiev.day02;

public class Outcome {

  public static Shape calculateMyShape(Shape opponent, char outcomeSign) {
    Game outcome = Decryptor.decryptOutcome(outcomeSign);

    if (outcome == Game.LOSE) {
      return switch (opponent) {
        case SCISSORS -> Shape.PAPER;
        case PAPER -> Shape.ROCK;
        case ROCK -> Shape.SCISSORS;
      };
    }

    if (outcome == Game.WIN) {
      return switch (opponent) {
        case SCISSORS -> Shape.ROCK;
        case PAPER -> Shape.SCISSORS;
        case ROCK -> Shape.PAPER;
      };
    }

    return opponent;
  }
}
