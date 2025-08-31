package ch01;

/**
 * <pre>
 * 배열 내의 최대 숫자를 찾는 프로그램
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 14.
 * @Version	:
 */
public class FindMaximum {

	public static void main(String[] args) {
		int[] intArray  =  {72, 60, 83, 47, 89, 95};

		int maximum = findMaximum(intArray);

		System.out.println("최대값 = " + maximum);

	}

	/**
	 * <pre>
	 * 1. 개요 : 최대값을 찾는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 * @return
	 */
	private static int findMaximum(int[] arr) {

		int max = arr[0];		// 최대값을 첫 번째 요소로  정한다

		// 최대 숫자를 배열의 두 번째 요소부터 마지막 요소까지 한 번에 한 요소와 차례대로 비교한다.
     	// 만약 비교한 요소가 최대 숫자보다 크다면 최대 숫자를 그 요소로 변경한다.
     	for (int i = 1 ; i < arr.length ; i++)
			if (arr[i] > max)
			    max = arr[i];

		return  max;
	}

}
