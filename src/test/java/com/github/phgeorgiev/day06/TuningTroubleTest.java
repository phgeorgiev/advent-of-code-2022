package com.github.phgeorgiev.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class TuningTroubleTest {

  static String input() throws IOException {
    return Files.readString(Path.of("src/test/resources/day06/input.txt"));
  }

  @Test
  void detectMarker() {
    assertEquals(7, new MarkerDetector("mjqjpqmgbljsphdztnvjfqwrcgsmlb").getFirstMarkerPosition());
    assertEquals(5, new MarkerDetector("bvwbjplbgvbhsrlpgdmjqwftvncz").getFirstMarkerPosition());
    assertEquals(6, new MarkerDetector("nppdvjthqldpwncqszvftbrmjlhg").getFirstMarkerPosition());
    assertEquals(10, new MarkerDetector("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").getFirstMarkerPosition());
    assertEquals(11, new MarkerDetector("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").getFirstMarkerPosition());
  }

  @Test
  void detectMarkerFromInput() throws IOException {
    assertEquals(1707, new MarkerDetector(input()).getFirstMarkerPosition());
  }

  @Test
  void detectMessage() {
    assertEquals(19, new MarkerDetector("mjqjpqmgbljsphdztnvjfqwrcgsmlb").getFirstMessagePosition());
    assertEquals(23, new MarkerDetector("bvwbjplbgvbhsrlpgdmjqwftvncz").getFirstMessagePosition());
    assertEquals(23, new MarkerDetector("nppdvjthqldpwncqszvftbrmjlhg").getFirstMessagePosition());
    assertEquals(29, new MarkerDetector("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").getFirstMessagePosition());
    assertEquals(26, new MarkerDetector("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").getFirstMessagePosition());
  }

  @Test
  void detectMessageFromInput() throws IOException {
    assertEquals(3697, new MarkerDetector(input()).getFirstMessagePosition());
  }
}
