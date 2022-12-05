package com.github.phgeorgiev.day03;

import java.util.List;

public class ElvesGroup {

  private final List<Rucksack> rucksacks;

  public ElvesGroup(List<Rucksack> rucksacks) {
    this.rucksacks = rucksacks;
  }

  public char getBadge() {
    String rucksackItems = rucksacks.get(0).getItems();
    for (int i = 0; i < rucksackItems.length(); i++) {
      if (rucksacks.get(1).containsItem(rucksackItems.charAt(i)) && rucksacks.get(2).containsItem(rucksackItems.charAt(i))) {
        return rucksackItems.charAt(i);
      }
    }

    return 0;
  }
}
