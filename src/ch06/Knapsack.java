package ch06;

/**
 * <pre>
 * 배낭 채우기 알고리즘 (동적 계획) 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 22.
 * @Version	:
 */
public class Knapsack
{
	/**
	 * <pre>
	 * 1. 개요 : 용량이 capacity인 배낭에 n개의 물건들을 넣어서 얻을 수 있는 최대 가치를 계산
	 * 2. 처리내용 : 
	 * </pre>
	 * @param capacity
	 * @param weight
	 * @param value
	 * @param n
	 * @return
	 */
	public int calcKnapSack(int capacity, int[] weight, int[] value, int n)
	{
		int[][] K = new int[n + 1][capacity + 1];		// 계산된 정보를 저장할 배열(하나 큰) 
		
		for (int i = 0; i <= n; i++)
		{
			K[i][0] = 0;					// 배낭의 용량이 0일 때 어떤 물건도 넣을 수 없다
		}
		
		for (int j = 0; j <= capacity; j++)
		{
			K[0][j] = 0;					// 배낭에 어떤 물건도 넣지 않을 때 0으로 초기화 
		}
		
		for (int i = 1; i <= n; i++)				// i는 물건 수 
		{
			for (int j = 1; j <= capacity; j++)		// j는 배낭의 용량  
			{
				if(weight[i-1] > j)					// 물건 i의 무게가 임시 배낭 용량을 초과하는 경우
				{
					K[i][j] = K[i-1][j];			// 이전 값으로 설정 
				}
				else 
				{
					K[i][j] = Math.max(value[i-1] + K[i-1][j - weight[i-1]], K[i-1][j]);
				}
			}
			printResult(K, n, capacity, i);
		}
		return K[n][capacity];
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 모든 쌍 최단 경로를 계산한 인접행렬을 출력하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param dist
	 * @param n
	 */
	public void printResult(int[][] K, int n, int c, int cnt)
	{
		System.out.println("물건 : " + cnt);
		
		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= c; j++)
			{				
				System.out.printf("%3d", K[i][j]);				
			}
			System.out.println();
		}
		System.out.println();
	}	
	
	public static void main(String[] args)
	{
		Knapsack ks = new Knapsack();
		int value[] = {25, 15, 20, 30};	// 물건의 가치 배열
		int weight[] = {3, 1, 2, 4};	// 물건의 무게 배열
		int capacity = 7;				// 배낭의 용량
		int n = value.length;			// 물건 수 

		System.out.println("최대 가치 = " + ks.calcKnapSack(capacity, weight, value, n));
	}

	
}
