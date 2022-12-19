package com.github.phgeorgiev.day10;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CathodeRayTube {

  private final Deque<String> instructionsSet;
  private final Deque<AddInstruction> instructionValues = new LinkedList<>();
  private int register = 1;
  private int signalSum = 0;
  private String crt = "";

  public CathodeRayTube(String instructionsSet) {
    this.instructionsSet = new LinkedList<>(Arrays.stream(instructionsSet.split("\n")).toList());
  }

  public int getSumOfSignalStrengths() {
    for (int i = 1; i <= 220; i++) {
      readNextInstruction(i);

      calculateRegister(i);

      if (i % 40 == 20) {
        signalSum += register * i;
      }
    }

    return signalSum;
  }

  public String getCrtOutput() {
    for (int i = 0; i < 240; i++) {
      readNextInstruction(i);

      calculateRegister(i);

      int crtPosition = i % 40;
      if (crtPosition >= register - 1 && crtPosition <= register + 1) {
        crt = crt.concat("#");
      } else {
        crt = crt.concat(".");
      }

      if (crtPosition == 39) {
        crt = crt.concat("\n");
      }
    }

    return crt;
  }

  private void readNextInstruction(int i) {
    if (!instructionValues.isEmpty() && instructionValues.getFirst().atInstruction() != i) {
      return;
    }

    String instruction = instructionsSet.pollFirst();
    if (instruction != null) {
      if (instruction.contains("addx")) {
        instructionValues.add(
            new AddInstruction(Integer.parseInt(instruction.split(" ")[1]), i + 2));
      }
    }
  }

  private void calculateRegister(int i) {
    if (!instructionValues.isEmpty() && instructionValues.getFirst().atInstruction() == i) {
      register += instructionValues.pollFirst().amount();
    }
  }
}
