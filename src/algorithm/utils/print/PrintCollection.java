package algorithm.utils.print;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintCollection {
  // 리스트를 문자열로 변환
  public static void listToString(List<Integer> list) {
    System.out.println(list.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]")));
  }

  // 배열을 문자열로 변환
  public static void arrayToString(int[] array) {
    System.out.println(Arrays.stream(array)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]")));
  }
}
