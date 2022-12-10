package com.github.phgeorgiev.day06;

public class MarkerDetector {

  private final String buffer;

  public MarkerDetector(String buffer) {
    this.buffer = buffer;
  }

  public int getFirstMarkerPosition() {
    return search("", buffer.charAt(0), 0, 4);
  }

  public int getFirstMessagePosition() {
    return search("", buffer.charAt(0), 0, 14);
  }

  private int search(String received, char c, int index, int length) {
    if (received.length() == length) {
      return index;
    }

    if (received.contains(String.valueOf(c))) {
      received = received.substring(received.indexOf(c) + 1);
    }

    return search(
        received.concat(String.valueOf(c)),
        buffer.charAt(index + 1),
        index + 1,
        length
    );
  }
}
