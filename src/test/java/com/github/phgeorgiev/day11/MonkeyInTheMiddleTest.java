package com.github.phgeorgiev.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MonkeyInTheMiddleTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 11;
  }

  @Test
  void shouldFindMonkeyBusiness() {
    String input = """
        Monkey 0:
          Starting items: 79, 98
          Operation: new = old * 19
          Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3
                
        Monkey 1:
          Starting items: 54, 65, 75, 74
          Operation: new = old + 6
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 0
                
        Monkey 2:
          Starting items: 79, 60, 97
          Operation: new = old * old
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 3
                
        Monkey 3:
          Starting items: 74
          Operation: new = old + 3
          Test: divisible by 17
            If true: throw to monkey 0
            If false: throw to monkey 1
        """;

    assertEquals(10605, new MonkeyInTheMiddle(input).getMonkeyBusiness(20, 3));
  }

  @Test
  void shouldFindMonkeyBusinessFromInput() throws IOException {
    assertEquals(67830, new MonkeyInTheMiddle(input()).getMonkeyBusiness(20, 3));
  }

  @Test
  void shouldFindMonkeyBusinessFor10000Rounds() {
    String input = """
        Monkey 0:
          Starting items: 79, 98
          Operation: new = old * 19
          Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3
                
        Monkey 1:
          Starting items: 54, 65, 75, 74
          Operation: new = old + 6
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 0
                
        Monkey 2:
          Starting items: 79, 60, 97
          Operation: new = old * old
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 3
                
        Monkey 3:
          Starting items: 74
          Operation: new = old + 3
          Test: divisible by 17
            If true: throw to monkey 0
            If false: throw to monkey 1
        """;

    assertEquals(2713310158L, new MonkeyInTheMiddle(input).getMonkeyBusiness(10000, 1));
  }

  @Test
  void shouldFindMonkeyBusinessFor10000RoundsFromInput() throws IOException {
    assertEquals(15305381442L, new MonkeyInTheMiddle(input()).getMonkeyBusiness(10000, 1));
  }
}
