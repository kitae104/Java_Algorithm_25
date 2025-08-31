package ch06;

/**
 * <pre>
 * 연속 행렬 곱셈 알고리즘
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 21.
 * @Version	:
 */
public class MatrixMultipication
{
	private static int cnt = 0;
	/**
	 * <pre>
	 * 1. 개요 : 분할 정복을 이용하여 최소 곱셈 횟수를 구하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public int matrixMult_DC(int[] arr, int i, int j)
	{
		//System.out.println(++cnt);
		if(i == j) 
		{
			return 0; 
		}
		else 
		{
			int min_val = Integer.MAX_VALUE;		// 아주 큰 값으로 초기화 
			
			for (int k = i; k < j; k++)
			{
				min_val = Math.min(min_val, matrixMult_DC(arr, i, k) 
						+ matrixMult_DC(arr, k+1, j) + arr[i-1] * arr[k] * arr[j]);   // 처음 * k번째 * 마지막 
			}	
			return min_val;
		}		
	}

	/**
	 * <pre>
	 * 1. 개요 : 동적 계획을 이용하여 최소 곱셈 횟수를 구하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param arr
	 * @param n 곱할 행렬들의 수 
	 * @return
	 */
	public int matrixMult_DP(int[] arr, int n)
	{
		//System.out.println(++cnt);
		// 프로그램을 단순화하기 위해 배열 m의 첫 번째 행과 첫 번째 열은 사용하지 않는다.
        int m[][] = new int[n][n];
        
        for (int i = 1; i < n; i++)
		{
			m[i][i] = 0;	//  최초의 m[1,1] = 0, m[2,2] = 0 ...  동작을 수행 
		}
        
        for(int len = 1; len < n; len++) {		// len은 행렬 곱셈들의 수
        	for (int i = 1; i < n - len; i++)
			{
				int j = i + len;
				m[i][j] = Integer.MAX_VALUE;	// 아주 큰 수로 초기화 
				
				for (int k = i; k < j; k++)
				{
					// 배열에 들어 있는 값을 이용해서 q 계산에 사용 
					int q = m[i][k] + m[k+1][j] + arr[i-1] * arr[k] * arr[j];
					if(q < m[i][j]) {			// 기존의 값보다 작은 경우 
						m[i][j] = q;			// 최소 값으로 업데이트 
					}
				}
			}
        }
		return m[1][n-1];
	}


	public static void main(String[] args)
	{
		MatrixMultipication mm = new MatrixMultipication();
		
		int arr[] = {10, 20, 50, 1, 100};
        int size = arr.length;

        System.out.println("분할 정복을 이용한 최소 곱셈 횟수: " + mm.matrixMult_DC(arr, 1, size-1));

        System.out.println("동적 계획을 이용한 최소 곱셈 횟수: " + mm.matrixMult_DP(arr, size));
	}

}
