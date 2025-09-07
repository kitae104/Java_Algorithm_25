package algorithm.search;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
public class DataFind {
  private int[] datas;

  /**
   * 100개의 임의 정수 데이터를 생성하여 내부 배열에 저장
   * 범위는 [0, 50) 예시. 필요 시 파라미터로 받아 확장 가능.
   * - 스트림(IntStream)과 람다를 활용하여 간결하게 생성
   */
  public void generateRandomData(int size, int bound){
    Random rand = new Random();

    datas = IntStream.range(0, size)
        .map(i -> rand.nextInt(bound))
        .toArray();
  }

  /**
   * 내부 배열을 오름차순으로 정렬
   * - Arrays.sort 내부적으로 최적화된 정렬 알고리즘 사용
   */
  public void sortAscending() {
    if(datas == null) {
      throw new IllegalStateException("데이터가 없습니다. generateRandomData() 메서드를 먼저 호출하세요.");
    }
    Arrays.sort(datas);
  }

  /**
   * 특정 값의 "첫 번째" 인덱스를 이진 탐색 + 좌측 확장으로 반환
   * - 정렬된 배열 기준으로 Arrays.binarySearch 사용
   * - 없으면 -1 반환
   */
  public int findFirstIndex(int target) {
    if (datas == null || datas.length == 0) {
      throw new IllegalStateException("데이터가 없습니다. generateRandomData() 메서드를 먼저 호출하세요.");
    }

    int index = Arrays.binarySearch(datas, target);
    if (index < 0) {
      return -1; // 값이 없음
    }

    // 좌측 확장하여 첫 번째 인덱스 찾기
    while (index > 0 && datas[index - 1] == target) {
      index--;
    }
    return index;
  }

  /**
   * 특정 값의 등장 횟수 반환
   * - 스트림 + 람다(filter)로 간결하게 계산
   */
  public long countOccurrences(int target){
    if (datas == null || datas.length == 0) {
      throw new IllegalStateException("데이터가 없습니다. generateRandomData() 메서드를 먼저 호출하세요.");
    }

    return Arrays.stream(datas)
        .filter(num -> num == target)
        .count();
  }

  /**
   * 현재 데이터 배열을 문자열로 반환 (확인용)
   * - 스트림으로 문자열 조합
   */
  public void printData() {
    if (datas == null || datas.length == 0) {
      throw new IllegalStateException("데이터가 없습니다. generateRandomData() 메서드를 먼저 호출하세요.");
    }

    String result = Arrays.stream(datas)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));

    System.out.println(result);
  }

  public int[] getDatas() {
    return datas;
  }
}
