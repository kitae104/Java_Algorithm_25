package ch05;

import java.util.Arrays;

/**
 * <pre>
 * 합병 정렬
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 19.
 * @Version	:
 */
public class MergeSort {

	/**
	 * <pre>
	 * 1. 개요 : 배열과 시작과 끝 값을 받아서 합병정렬을 수행하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 * @param low
	 * @param high
	 */
	public void mergeSort(int[] intArray, int low, int high) 
	{
		if(low < high)
		{
			int mid = (low + high) / 2;			// 중간 값에 대한 인덱스 
			
			mergeSort(intArray, low, mid);		// 왼쪽의 반을 분할 하면서 정렬 
			mergeSort(intArray, mid+1, high);	// 오른쪽의 반을 분할 하면서 정렬 
			
			merge(intArray, low, mid, high);	// 정렬된 내용을 합병하기 
		}		
	}
	
	/**
	 * <pre>
	 * 1. 개요 : mid 값을 기준으로 각각 정렬된 배열을 합병하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 * @param low
	 * @param mid
	 * @param high
	 */
	public void merge(int[] intArray, int low, int mid, int high) 
	{		
		int[] temp = new int[high + 1];		// 합병된 결과를 저장하기 위한 임시 배열
		int h = low;						// 임시 배열의 인덱스 
		int i = low;						// 왼쪽 배열의 인덱스 
		int j = mid + 1;					// 오른쪽 배열의 인덱스 
		
		// 왼쪽 반의 요소와 오른쪽 반의 요소를 순서대로 비교하여 작은 값을 임시 배열로 옮긴다
		while(i <= mid && j<=high)
		{
			if(intArray[i] <= intArray[j]) 
			{
				temp[h] = intArray[i];			// 오른쪽이 큰 경우 왼쪽 값을 임시 배열에 옮김
				i = i + 1;						// i 값을 증가 시킴
			} 
			else 
			{
				temp[h] = intArray[j];			// 왼쪽이 큰 경우 오른쪽 값을 임시 배열에 옮김
				j = j + 1;						// j 값을 증가 시킴
			}
			h = h + 1;							// 임시 배열의 인덱스 증가 
		}
		
		if(i > mid)								  
		{	// 오른쪽에 남아있는 요소를 임시 배열에 옮긴다.
			for(int k = j; k <= high; k++)
			{
				temp[h] = intArray[k];
				h = h + 1;
			}
		}
		else 
		{	// 왼쪽에 남아있는 요소를 임시 배열에 옮긴다.
			for(int k = i; k <= mid; k++)
			{
				temp[h] = intArray[k];
				h = h + 1;
			}
		}
		
		for (int l = low; l <= high; l++) 
		{	// 임시 배열 B[low..high]를 배열 A[low..high]로 옮긴다
			intArray[l] = temp[l];
		}
	}


	/**
	 * <pre>
	 * 1. 개요 : 배열의 모든 요소를 한 줄로 출력하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 */
	public void printArray(int[] intArray) 
	{
		for (int i = 0; i < intArray.length; ++i) 
		{
            System.out.print(intArray[i] + " ");
		}
        System.out.println();
	}
	
	public static void main(String[] args) 
	{	
		MergeSort ms = new MergeSort();
		
		int intArray[] = {91, 82, 13, 85, 68, 70, 98, 24};
		
		// 정렬하기 전 배열 요소들을 출력한다
        System.out.println("주어진 배열");
        ms.printArray(intArray);

        ms.mergeSort(intArray, 0, intArray.length-1);	// 병합 정렬 메소드 호출 
        
        // 정렬 후 배열 요소들을 출력한다
        System.out.println("\n정렬된 배열");
        ms.printArray(intArray);

	}
}
