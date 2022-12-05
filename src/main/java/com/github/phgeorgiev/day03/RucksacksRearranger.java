package com.github.phgeorgiev.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RucksacksRearranger {

  private final List<Rucksack> rucksacks;
  private final List<ElvesGroup> elvesGroups = new ArrayList<>();

  public RucksacksRearranger(String rucks) {
    rucksacks = Arrays.stream(rucks.split("\n")).map(Rucksack::new).toList();
    for (int i = 0; i < rucksacks.size(); i += 3) {
      elvesGroups.add(
          new ElvesGroup(Arrays.asList(
              rucksacks.get(i),
              rucksacks.get(i + 1),
              rucksacks.get(i + 2)
          ))
      );
    }
  }

  public int getPriorityRearrangementSum() {
    return rucksacks.stream()
        .reduce(0, (acc, rucksack) -> acc + rucksack.getPriorityRearrangement(), Integer::sum);
  }

  public int getBadgePriorityRearrangementSum() {
    return elvesGroups.stream()
        .map(ElvesGroup::getBadge)
        .map(Rucksack::getPriorityForItem)
        .reduce(0, Integer::sum);
  }
}
