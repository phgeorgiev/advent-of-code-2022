package com.github.phgeorgiev.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DistressSignalTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 13;
  }

  @Test
  void shouldFindSumOfRightOrder() {
    String input = """
        [1,1,3,1,1]
        [1,1,5,1,1]
                
        [[1],[2,3,4]]
        [[1],4]
                
        [9]
        [[8,7,6]]
                
        [[4,4],4,4]
        [[4,4],4,4,4]
                
        [7,7,7,7]
        [7,7,7]
                
        []
        [3]
                
        [[[]]]
        [[]]
                
        [1,[2,[3,[4,[5,6,7]]]],8,9]
        [1,[2,[3,[4,[5,6,0]]]],8,9]
        """;

    assertEquals(13, new DistressSignal(input).sumRightOrderedSignals());
  }

  @Test
  void shouldFindSumOfRightOrderFromInput() throws IOException {
    assertEquals(5717, new DistressSignal(input()).sumRightOrderedSignals());
  }
}
