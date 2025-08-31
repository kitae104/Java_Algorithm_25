package ch05;

/**
 * <pre>
 * 분할 정복을 이용하여 배열의 최솟값과 최댓값을 찾는다
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 18.
 * @Version	:
 */
public class FindMaxMin {
	
	/**
	 * <pre>
	 * 1. 개요 : 배열에서 최대, 최소 값 찾는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param iArray 배열 
	 * @param i 시작 인덱스 
	 * @param j 종료 인덱스 
	 * @return
	 */
	public int[] findMaxMin(int[] iArray, int i, int j) {
		int mid;						// A[i..j]의 중앙 요소의 지수
	    int[] result = new int[2];		// A[i..j]의 최솟값과 최댓값을 저장하는 배열
	    int[] leftResult = new int[2];	// A[i..mid]의  최솟값과 최댓값을 저장하는 배열
	    int[] rightResult = new int[2]; // A[mid+1..j]의  최솟값과 최댓값을 저장하는 배열
	    
	    if (i == j) {					// 배열에 원소가 1개만 있는 경우 
	    	result[0] = iArray[i];
	    	result[1] = iArray[i];
	    } else if(i == j-1) {			// 배열에 2 개의 요소들이 있는 경우
	    	if(iArray[i] < iArray[j]) {
	    		result[0] = iArray[i];	// 최소값은 result[0]
		    	result[1] = iArray[j];	// 최대값은 result[1]
	    	} else {
	    		result[0] = iArray[j];
		    	result[1] = iArray[i];
	    	}
	    } else {						// 일반적인 경우(원소가 여러개인 일반적인 경우 
	    	mid = (i + j) / 2;			// A[i..j]의 중앙 요소의 인덱스 계산
	    	
	    	leftResult = findMaxMin(iArray, i, mid);		// 왼쪽 배열에 대한 결과 
	    	rightResult = findMaxMin(iArray, mid+1, j);		// 오른쪽 배열에 대한 결과
	    	
	    	if(leftResult[0] < rightResult[0]) {
	    		result[0] = leftResult[0];					// 최소값 유지 
	    	} else {
	    		result[0] = rightResult[0];
	    	}
	    	if(leftResult[1] < rightResult[1]) {
	    		result[1] = rightResult[1];					// 최대값 유지 
	    	} else {
	    		result[1] = leftResult[1];
	    	}
	    }
		return result;
	}
	
	public static void main(String[] args) {
		int[] iArray = {24, 75, 92, 83, 61, 48, 97, 50};
		int[] answer = new int[2];
		
		FindMaxMin fmm = new FindMaxMin();
		
		// 배열 A의 최솟값과 최댓값을 찾는다
		answer = fmm.findMaxMin(iArray, 0, iArray.length - 1);
		
		// 배열 A의 최솟값과 최댓값을 출력한다
		System.out.println("최솟값: " + answer[0]);
		System.out.println("최댓값: " + answer[1]);		
	}	
}
