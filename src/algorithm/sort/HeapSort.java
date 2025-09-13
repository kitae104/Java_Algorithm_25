package algorithm.sort;

public class HeapSort {
  // 최대 힙 기반 힙 정렬
  public static void heapSort(int[] arr) {
    int n = arr.length;

    // 1. 주어진 배열을 최대 힙(Max Heap)으로 변환
    //    (힙은 완전 이진 트리 구조이며, 부모 노드가 자식 노드보다 항상 크다)
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i); // 각 부모 노드에 대해 힙 성질 유지
    }

    // 2. 힙에서 루트(가장 큰 값)를 하나씩 꺼내 배열 뒤로 이동
    //    꺼낸 뒤 남은 부분을 다시 최대 힙으로 재구성
    for (int i = n - 1; i > 0; i--) {
      // 현재 힙의 루트(최대값)와 끝 요소를 교환
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // 힙 크기를 줄여가며 다시 최대 힙 유지
      heapify(arr, i, 0);
    }
  }

  // 최대 힙 성질을 유지하는 메서드
  // arr[] : 정렬 대상 배열
  // n     : 힙의 크기
  // i     : 힙에서 확인할 노드의 인덱스
  public static void heapify(int[] arr, int n, int i) {
    int largest = i;       // 현재 노드를 가장 큰 값이라고 가정
    int left = 2 * i + 1;  // 왼쪽 자식 노드 인덱스
    int right = 2 * i + 2; // 오른쪽 자식 노드 인덱스

    // 왼쪽 자식이 존재하고 현재 노드보다 크다면 largest 갱신
    if (left < n && arr[left] > arr[largest]) largest = left;

    // 오른쪽 자식이 존재하고 현재까지의 largest보다 크다면 largest 갱신
    if (right < n && arr[right] > arr[largest]) largest = right;

    // largest가 i와 다르다면 교환 발생 (부모 < 자식인 경우)
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      // 교환 후 하위 트리에 대해서도 힙 성질 유지 필요 → 재귀 호출
      heapify(arr, n, largest);
    }
  }
}
