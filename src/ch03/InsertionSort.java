package ch03;

/**
 * <pre>
 * 삽입 정렬을 사용하여 정렬한다
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 15.
 * @Version	:
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		int[] intArray = {45, 89, 67, 92, 74, 26, 80};
		
		System.out.print("정렬 전 배열: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + "  ");
		}
		System.out.println();
		
		// 선택 정렬을 사용하여 정렬하기 위해 insertionSort 메소드를 호출한다
		insertionSort(intArray);
		
		System.out.print("정렬 후 배열: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + "  ");
		}
		System.out.println();
	}

	/**
	 * <pre>
	 * 1. 개요 : 삽입 정렬을 수행하는 메소드
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 */
	private static void insertionSort(int[] intArray) {
		
		for (int i = 1; i < intArray.length; i++) {
			int insertElement = intArray[i];
			int j = i - 1;
			
			// A[i]를 A[0 .. i-1]에 삽입할 인덱스를 찾는다
			while(j >= 0 && intArray[j] > insertElement) {
				intArray[j+1] = intArray[j];
				j = j - 1;
			}
			
			intArray[j+1] = insertElement;	// intArray[i]를 찾은 위치에 삽입한다
		}
		
	}
}
