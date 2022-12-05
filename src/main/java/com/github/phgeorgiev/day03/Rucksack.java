package com.github.phgeorgiev.day03;

public class Rucksack {

  private final String firstCompartment;
  private final String secondCompartment;


  public Rucksack(String items) {
    firstCompartment = items.substring(0, items.length() / 2);
    secondCompartment = items.substring(items.length() / 2);
  }

  public static int getPriorityForItem(char item) {
    int priority = Character.isUpperCase(item) ? item - 'A' + 26 : item - 'a';

    return priority + 1;
  }

  public boolean containsItem(char item) {
    return firstCompartment.contains(Character.toString(item)) || secondCompartment.contains(Character.toString(item));
  }

  public String getItems() {
    return firstCompartment.concat(secondCompartment);
  }

  public int getPriorityRearrangement() {
    char itemInBothCompartments = 0;
    for (int i = 0; i < firstCompartment.length(); i++) {
      if (secondCompartment.contains(Character.toString(firstCompartment.charAt(i)))) {
        itemInBothCompartments = firstCompartment.charAt(i);
        break;
      }
    }

    return itemInBothCompartments != 0 ? getPriorityForItem(itemInBothCompartments) : 0;
  }
}
