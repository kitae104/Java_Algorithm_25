package ch05;
/**
 * <pre>
 * 선택 정렬 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 20.
 * @Version	:
 */
public class Selection
{
	/**
	 * <pre>
	 * 1. 개요 : 선택 정렬 처리 
	 * 2. 처리내용 : 배열 intArray[first..last]내에서 k번째 작은 요소를 찾아서 반환한다
	 * </pre>
	 * @param arr
	 * @param first
	 * @param last
	 * @param k k번째 위치(작은 수의 위치)
	 * @return
	 */
	public int selection(int[] arr, int first, int last, int k)
	{
		int p = partition(arr, first, last);	// 파티션할 위치 
		int s = (p - 1) -first + 1;				// intArray[p]보다 작거나 같은 요소들의 수를 계산한다
		
		if (k <= s)								// intArray[p]보다 작거나 같은  요소들의 Small 그룹에서 찾는다
		{
			return selection(arr, first, p-1, k);
		}
		else if (k == s + 1) {
			return arr[p];						// k번재 작은 원소를 찾은 경우(답을 찾은 경우)
		}
		else {									// Large 그룹에서 찾기 
			return selection(arr, p+1, last, k - s - 1);
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 분할을 수행하는 메소드 
	 * 2. 처리내용 : 퀵소트에 있는 함수로 대체해서 처리함 
	 * </pre>
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] arr, int low, int high) 
	{
		int i, j, temp;
		
		i = low + 1;		// 기준 다음위치 
		j = high;			// 마지막 위치 
		
		// 배열을 arr[low]를 기준으로 하여 기준보다 
		// 큰 요소는 오른쪽으로 옮기고 작은 원소는 왼쪽으로 옮긴다.
		while(i<=j) 
		{
			if(arr[i] <= arr[low]) 
			{
				i = i + 1;
			}
			else if (arr[j] > arr[low]) 
			{
				j = j - 1;
			}
			else
			{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i = i + 1;
				j = j - 1;						
			}
		}
		
		// intArray[low]를 intArray[low]보다 작거나 같은 요소들의 구역의 마지막 요소와 교환
		temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		return j;						// 파티션 기준을 옮긴 인덱스 반환  
	}

	public static void main(String[] args)
	{
		Selection s = new Selection();
		
		int arr[] = {48, 12, 70, 38, 75, 67, 96, 52, 81};
        int k = 5;

        System.out.println(k + "번째로  작은 요소: " + s.selection(arr, 0, arr.length - 1, k) );

	}
}
