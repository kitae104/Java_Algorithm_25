package ch03;

/**
 * <pre>
 * 선택 정렬을 사용하여 정렬하기 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 15.
 * @Version	:
 */
public class SelectionSort {
	public static void main(String[] args) {
		
		int[] intArray = {89, 45, 67, 92, 39, 74, 26, 90};
		int i;

		// 정렬하기 전 배열을 출력한다
		System.out.print("정렬 전 배열: ");

		for (i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + "  ");

		// 선택 정렬을 사용하여 정렬하기 위해 selectionSort 메소드를 호출한다
		selectionSort(intArray);

		// 정렬한 후 배열을 출력한다
		System.out.print("\n정렬 후 배열: ");

		for (i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + "  ");
	}

	/**
	 * <pre>
	 * 1. 개요 : 선택 정렬을 수행하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param iArr
	 */
	private static void selectionSort(int[] iArr) {
		int min, temp;
		
		for (int i = 0; i < iArr.length - 1; i++) {
			
			min = i;	// 현재 인덱스 i를 최소 인덱스로 설정 

			for (int j = i + 1; j < iArr.length; j++)
			   if (iArr[j] < iArr[min])		// 비교후  
				   min = j;					// 변경 
			
			// 현재 인덱스의 값과 최소인덱스의 값을 교환  
			temp = iArr[min];
			iArr[min] = iArr[i];
			iArr[i] = temp;
		}		
	}
}
