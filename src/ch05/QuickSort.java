package ch05;

/**
 * <pre>
 * 퀵 정렬 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 19.
 * @Version	:
 */
public class QuickSort 
{
	/**
	 * <pre>
	 * 1. 개요 : 퀵 정렬을 수행하는 메소드
	 *           - 파티션 부분 
	 *           - 퀵 소트 부분 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void quickSort(int[] arr, int low, int high) 
	{
		
		
		
		if(low < high) 
		{
			int pivot = partition(arr, low, high);
			System.out.println("피벗: " + arr[pivot]);
			printArray(arr);
			quickSort(arr, low, pivot -1);
			quickSort(arr, pivot + 1, high);
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 분할을 수행하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] arr, int low, int high) 
	{
		int i, j, temp;
		
		i = low + 1;		// 기준 다음위치 - 제일 작은 값은 기준 값 
		j = high;			// 마지막 위치 
		
		// 배열을 arr[low]를 기준으로 하여 기준보다 
		// 큰 요소는 오른쪽으로 옮기고 작은 원소는 왼쪽으로 옮긴다.
		while(i<=j) 
		{
			if(arr[i] <= arr[low])    			// 작은 경우 통과 
			{
				i = i + 1;
			}
			else if (arr[j] > arr[low]) 		// 큰 경우 통과 
			{
				j = j - 1;
			}
			else								// 교환이 필요한 경우 
			{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i = i + 1;
				j = j - 1;						
			}
		}
		
		// arr[low]를 arr[low]보다 작거나 같은 요소들의 구역의 마지막 요소와 교환
		temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		return j;						// 파티션 기준을 옮긴 인덱스 반환  
	}

	/**
	 * <pre>
	 * 1. 개요 : 배열의 모든 요소를 한 줄로 출력하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 */
	public void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; ++i) 
		{
            System.out.print(arr[i] + " ");
		}
        System.out.println();
	}
	
	public static void main(String[] args) 
	{
		QuickSort qs = new QuickSort();
		
		int arr[] = {15, 22, 13, 27, 12, 10, 20, 25};
		//int intArray[] = {55, 99, 66, 77, 44, 88};

        System.out.println("주어진 배열");



        qs.quickSort(arr, 0, arr.length - 1);

        System.out.println("\n정렬된 배열");
        qs.printArray(arr);
	}
}
