package com.github.phgeorgiev.day07;

import java.util.LinkedList;
import java.util.List;

public class Directory {

  private final List<Directory> directories;
  private final List<Integer> files = new LinkedList<>();

  public Directory() {
    directories = new LinkedList<>();
  }

  private static int filesSize(Directory directory) {
    return directory.files.stream().reduce(0, Integer::sum);
  }

  private static int directoriesSize(List<Directory> directories) {
    return directories.stream().reduce(0, (acc, dir) -> acc + getDirSize(dir), Integer::sum);
  }

  private static int getDirSize(Directory dir) {
    if (dir.directories.isEmpty()) {
      return filesSize(dir);
    }

    return filesSize(dir) + directoriesSize(dir.directories);
  }

  public void addDir(Directory dir) {
    directories.add(dir);
  }

  public void addFile(Integer file) {
    files.add(file);
  }

  public int getTotalSize() {
    int filesSize = filesSize(this);
    if (directories.isEmpty()) {
      return filesSize;
    }

    return filesSize + directoriesSize(directories);
  }
}
