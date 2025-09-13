package practices.search;

import java.util.Scanner;

public class DataFindMain {
  public static void main(String[] args) {
    DataFind df = new DataFind();

    df.generateRandomData(20, 10);   // 0~49 사이로 생성
    df.printData();
    df.sortAscending();

    System.out.println("정렬된 데이터(오름차순):");
    df.printData();

    // Scanner로 외부 입력을 받아 특정 숫자 검색 및 개수 출력
    // try-with-resources 구문으로 Scanner 자동 종료
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("\n찾고 싶은 숫자를 입력하세요: ");
      // 입력이 정수가 아닌 경우 대비
      while (!sc.hasNextInt()) {
        System.out.print("정수를 입력하세요: ");
        sc.next();
      }
      int target = sc.nextInt();

      int firstIdx = df.findFirstIndex(target);
      long count = df.countOccurrences(target);

      // 결과 출력
      if (firstIdx == -1) {
        System.out.printf("숫자 %d 는 배열에 존재하지 않습니다.\n", target);
      } else {
        System.out.printf("숫자 %d 의 첫 번째 위치(인덱스): %d\n", target, firstIdx);
        System.out.printf("숫자 %d 의 전체 개수: %d\n", target, count);
      }
    }
  }
}
