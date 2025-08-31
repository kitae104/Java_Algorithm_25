
package ch03;

/**
 * <pre>
 * 힙 정렬을 사용하여 정렬한다
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 16.
 * @Version	:
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] intArray = {0, 2, 7, 5, 3, 9, 1, 8};
		
		// 정렬하기 전 배열을 출력한다
		System.out.print("정렬 전 배열: ");

		for (int i = 1; i < intArray.length; i++)
			System.out.print(intArray[i] + "  ");

		// 힙 정렬을 사용하여 정렬하기 위해 heapSort 메소드를 호출한다
		heapSort(intArray);

		// 정렬한 후 배열을 출력한다
		System.out.print("\n정렬 후 배열: ");

		for (int i = 1; i < intArray.length; i++)
			System.out.print(intArray[i] + "  ");
	}

	/**
	 * <pre>
	 * 1. 개요 : 힙정렬을 수행하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray : 마지막 인덱스 
	 */
	private static void heapSort(int[] intArray) {
		int endIndex = intArray.length - 1;		// 배열 크기에서 -1값을 마지막 인덱스로 설정 

		// 주어진 배열을 힙으로 만든다
		buildHeap(intArray, endIndex);
		System.out.print("\n힙 생성 후 배열: ");
		for (int i = 1; i < intArray.length; i++)
			System.out.print(intArray[i] + "  ");

		// 힙에서 최대값을 제거하고 남은 트리를 다시 힙으로 만든다
		while (endIndex > 1) {
			// A[1]과 A[endIndex]를 교환한다
			int temp = intArray[1];
			intArray[1] = intArray[endIndex];
			intArray[endIndex] = temp;

            // 힙에서 최댓값을 제거한다
            endIndex = endIndex - 1;

            // 남은 트리를 다시 힙으로 만든다
            pushDown(intArray, 1, endIndex/2, endIndex);
		}
		
	}

	/**
	 * <pre>
	 * 1. 개요 : 배열 정보를 이용해서 힙으로 생성하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray 배열
	 * @param endIndex 마지막 인덱스
	 */
	private static void buildHeap(int[] intArray, int endIndex) {

		int checkIndex = (intArray.length - 1)/2 + 1;	// 힙 조건이 되는지 확인하기 위해 체크하는 인덱스 
		
		while (checkIndex > 1) {
			checkIndex = checkIndex - 1;
			int x = checkIndex;

			// x에서 힙 조건이 만족될 때까지 A[x]를 트리의 아래 층으로 내려 보낸다
			pushDown(intArray, x, checkIndex, endIndex);
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : intArray[x]를 힙 조건이 만족될 때까지 트리의 아래 층으로 내려 보낸다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray 배열
	 * @param x 인텍스
	 * @param checkIndex 체크할 인덱스
	 * @param endIndex 마지막 인덱스
	 */
	private static void pushDown(int[] intArray, int x, int checkIndex, int endIndex) {

		int largeChildIndex = findLarger(intArray, x, endIndex);	// A[x]보다 더 큰 값을 갖는 x의 자식의 인덱스
		
		while (intArray[x] < intArray[largeChildIndex]) { // 현재 x와 자식을 비교한 후 교환  
			// 교환
			int temp = intArray[x];
			intArray[x] = intArray[largeChildIndex];
			intArray[largeChildIndex] = temp;

			x = largeChildIndex;	// x를 변경 

			largeChildIndex = findLarger(intArray, x, endIndex);	//  A[x]보다 더 큰 값을 갖는 x의 자식의 인덱스
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : intArray[x]보다 더 큰 값을 가지는 x의 자식 노드의 인덱스를 구한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray 배열
	 * @param x 힙 조건을 확인 중인 노드의 인덱스 
	 * @param endIndex intArray[x] 보다 더 큰 값을 가지는 x의 자식 노드의 인덱스 
	 * @return
	 */
	private static int findLarger(int[] intArray, int x, int endIndex) {
		int largeChildIndex = 0;

		if (2*x + 1 <= endIndex) {
			
			// 자식 노드가 둘 다 있는 경우
			if (intArray[2*x] > intArray[x] || intArray[2*x + 1] > intArray[x]) {
				
				// A[x]보다 더 큰 값을 가지는 자식 노드의 지수를 구한다
				if (intArray[2*x] >= intArray[2*x + 1]) {  // 왼쪽이 큰 경우 
					largeChildIndex = 2*x;
				}
				else {
					largeChildIndex = 2*x + 1;	// 오른쪽을 처리한 경우 
				}
			}
		} else { // 자식 노드가 하나만 있는 경우
		    if (2*x <= endIndex && intArray[2*x] > intArray[x]) {
		    	largeChildIndex = 2*x;
		    }
		}
		
		return largeChildIndex;
	}
}
