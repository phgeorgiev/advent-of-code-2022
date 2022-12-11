package com.github.phgeorgiev.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.phgeorgiev.BaseTestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class NoSpaceLeftOnDeviceTest extends BaseTestUtils {

  @Override
  protected Integer getDay() {
    return 7;
  }

  @Test
  void shouldFindDirectoriesWithTotalSizeAtMostOf100000() {
    String filesystem = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
        """;

    assertEquals(95437, new DirectoryManager(filesystem).findDirBySize(100000));
  }

  @Test
  void shouldFindDirectoriesWithTotalSizeAtMostOf100000FromInput() throws IOException {
    assertEquals(1297159, new DirectoryManager(input()).findDirBySize(100000));
  }

  @Test
  void shouldFindDirectorySizeForDeletion() {
    String filesystem = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
        """;

    assertEquals(24933642, new DirectoryManager(filesystem).findDirForDeletion(70000000, 30000000));
  }

  @Test
  void shouldFindDirectorySizeForDeletionFromInput() throws IOException {
    assertEquals(3866390, new DirectoryManager(input()).findDirForDeletion(70000000, 30000000));
  }
}
