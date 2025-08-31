package ch02;

/**
 * <pre>
 * 이진 탐색 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 9. 11.
 * @Version	:
 */
public class BinarySearch
{

	public static void main(String[] args)
	{
		int[] A = {10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47};
		int x = 18;
		int n = A.length;
		int location;

		location = binarySearch(A, 0, n - 1, x);

		System.out.println(x + "의 지수 = " + location);
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : target이 배열 A[first .. last]내에 있는지를 확인하기 위해 이진 탐색을 사용한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param A			배열 
	 * @param first		첫번째 인덱스 
	 * @param last		마지막 인덱스 
	 * @param target 	찾는 값
	 * @return			있으면 해당 요소의 지수, 없으면 -1
	 */
	public static int binarySearch(int[] A, int first, int last, int target)
	{
		int result; 
		
		if(first > last)		// 찾지 못한 경우
		{
			result = -1;
		}
		else 
		{
			int mid = (first + last) / 2;		// 중간 요소의 인덱스를 계산 
			
			if (target == A[mid])				// target이 중간 요소와 같아 찾은 경우
			{
				result = mid;
			}
			else if(target < A[mid])			// target이 중간 요소보다 작다면 앞쪽 반에서 찾느다	
			{
				result = binarySearch(A, first, mid - 1 , target);
			}
			else 
			{
				result = binarySearch(A, mid + 1, last, target);
			}
		}
		return result;
	}
}
