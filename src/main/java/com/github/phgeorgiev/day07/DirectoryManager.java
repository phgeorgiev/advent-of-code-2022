package com.github.phgeorgiev.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DirectoryManager {

  private final Map<String, Directory> tree;
  private List<String> position;

  public DirectoryManager(String filesystem) {
    position = new LinkedList<>() {{
      add("/");
    }};

    tree = new HashMap<>() {{
      put("/", new Directory());
    }};

    parseInput(filesystem);
  }

  public int findDirBySize(int size) {
    return new ArrayList<>(tree.values())
        .stream()
        .mapToInt(Directory::getTotalSize)
        .filter(dirSize -> dirSize <= size)
        .reduce(0, Integer::sum);
  }

  public int findDirForDeletion(int totalSize, int minSize) {
    int freeSpace = totalSize - tree.get("/").getTotalSize();
    int spaceNeeded = minSize - freeSpace;
    return new ArrayList<>(tree.values())
        .stream()
        .mapToInt(Directory::getTotalSize)
        .filter(dirSize -> dirSize >= spaceNeeded)
        .boxed()
        .sorted()
        .toList()
        .get(0);
  }

  private void parseInput(String filesystem) {
    Arrays.stream(filesystem.split("\n")).forEach(line -> {
      if (line.contains("$")) {
        if (line.contains("cd")) {
          String dir = line.split(" ")[2];
          if (dir.equals("/")) {
            position = new LinkedList<>() {{
              add("/");
            }};
          } else if (dir.equals("..")) {
            position.remove(position.size() - 1);
          } else {
            position.add(dir);
          }
        }
      } else {
        if (line.contains("dir")) {
          String dirName = line.split(" ")[1];
          String newPosition = positionMarker().endsWith("/") ? positionMarker() + dirName : positionMarker() + "/" + dirName;
          if (!tree.containsKey(newPosition)) {
            Directory newDir = new Directory();
            tree.put(newPosition, newDir);
            tree.get(positionMarker()).addDir(newDir);
          }
        } else {
          tree.get(positionMarker()).addFile(
              Integer.parseInt(line.split(" ")[0])
          );
        }
      }
    });
  }

  private String positionMarker() {
    return position.size() == 1
        ? position.get(0)
        : String.join("/", position).substring(1);
  }
}
