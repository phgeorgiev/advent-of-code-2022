package com.github.phgeorgiev.day10;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CathodeRayTube {

  private final Deque<String> instructionsSet;
  private final Deque<AddInstruction> instructionValues = new LinkedList<>();
  private int register = 1;
  private int signalSum = 0;

  public CathodeRayTube(String instructionsSet) {
    this.instructionsSet = new LinkedList<>(Arrays.stream(instructionsSet.split("\n")).toList());
  }

  public int getSumOfSignalStrengths() {
    for (int i = 1; i <= 220; i++) {
      readNextInstruction(i);

      if (!instructionValues.isEmpty() && instructionValues.getFirst().atInstruction() == i) {
        register += instructionValues.pollFirst().amount();
      }

      if (i % 40 == 20) {
        signalSum += register * i;
      }
    }

    return signalSum;
  }

  private void readNextInstruction(int i) {
    if (!instructionValues.isEmpty() && instructionValues.getFirst().atInstruction() != i) {
      return;
    }

    String instruction = instructionsSet.pollFirst();
    if (instruction != null) {
      if (instruction.contains("addx")) {
        instructionValues.add(
            new AddInstruction(Integer.parseInt(instruction.split(" ")[1]), i + 2)
        );
      }
    }
  }
}
