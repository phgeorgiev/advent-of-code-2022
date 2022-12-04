package com.github.phgeorgiev.day02;

import java.util.HashMap;
import java.util.Map;

public class Decryptor {

  private final static Map<Character, Shape> encryptedShapes = new HashMap<>() {{
    put('A', Shape.ROCK);
    put('B', Shape.PAPER);
    put('C', Shape.SCISSORS);
  }};

  private final static Map<Character, Game> encryptedOutcome = new HashMap<>() {{
    put('X', Game.LOSE);
    put('Y', Game.DRAW);
    put('Z', Game.WIN);
  }};

  public static Shape decryptShape(char shape) {
    return encryptedShapes.get(shape);
  }

  public static Game decryptOutcome(char outcome) {
    return encryptedOutcome.get(outcome);
  }
}
