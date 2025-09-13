package algorithm.utils.number;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateNumber {
  // 정수형 배열 생성
  public static int[] intArray(int size, int bound) {
    Random rand = new Random();
    return IntStream.range(0, size)
        .map(i -> rand.nextInt(bound))
        .toArray();
  }

  // 정수형 리스트 생성
  public static List<Integer> intList(int size, int bound) {
    Random rand = new Random();
    return IntStream.range(0, size)
        .map(i -> rand.nextInt(bound))
        .boxed()
        .toList();
  }

}
