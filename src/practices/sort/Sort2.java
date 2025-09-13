package practices.sort;

import algorithm.utils.print.PrintCollection;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Sort2 {
  public static void main(String[] args) {
    // 1. 임의의 정수 20개 생성 (범위: 1~100)
    List<Integer> numbers = new Random()
        .ints(20, 1, 101) // 20개, 1~100 범위
        .boxed()
        .collect(Collectors.toList());

    // 현재 상태 출력
    System.out.println("현재 상태:");
    numbers.forEach(n -> System.out.print(n + " "));
    System.out.println("\n");
    PrintCollection.listToString(numbers);

    // 2. 오름차순 정렬 (Stream 사용)
    List<Integer> sortedNumbers = numbers.stream()
        .sorted()
        .collect(Collectors.toList());

    // 정렬된 상태 출력
    System.out.println("오름차순 정렬 후 상태:");
    sortedNumbers.forEach(n -> System.out.print(n + " "));
    System.out.println();

    // 3. 내림차순 정렬 (Stream 사용)
    List<Integer> descSortedNumbers = numbers.stream()
        .sorted(Comparator.reverseOrder())
        .toList();

    // 정렬된 상태 출력
    System.out.println("내림차순 정렬 후 상태:");
    descSortedNumbers.forEach(n -> System.out.print(n + " "));
    System.out.println();
  }


}
