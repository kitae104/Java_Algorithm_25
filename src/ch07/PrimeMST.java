package ch07;

/**
 * 프림(Prim)의 최소 비용 신장 트리 알고리즘
 * 
 * @author 김기태
 *
 */
public class PrimeMST
{

	public final static int INF = 9999;

	/**
	 * <pre>
	 * 1. 개요 : 최소 비용 신장 트리에 포함된 간선들을 찾아서 출력
	 * 2. 처리내용 : 
	 * </pre>
	 * @param w
	 * @param n
	 */
	private void primMST(int[][] W, int n)
	{
		int[] near = new int[n];				// 각 청색 정점에 가장 가까운 적색 정점을 저장하는 배열 
		boolean[] isBlue = new boolean[n];		// 각 정점이 청색이면 true를 아니면 false를 저장하는 배열
		
		// 정점 0을 적색 정점으로 초기화한다
		isBlue[0] = false;
		int newRed = 0;
		
		System.out.println("최소 비용 신장 트리에 포함된 간선 목록\n");
		System.out.println("간선\t가중치");
		
		// 정점 0을 제외한 모든 정점을 청색으로 가장 가까운 정점을 정점 0으로 초기화한다
		for (int i = 1; i < n; i++)
		{
			isBlue[i] = true;
			near[i] = 0;
		}
		
		// 각 반복에서 한 적색 정점과 한 청색 정점을 연결하는 가장 가중치가 작은 간선을 선택한 후
		// 그 간선을 최소 비용 신장 트리에 추가한다
		for (int i = 1; i < n; i++)
		{
			int minVal = INF;			// 최소 값 초기화 무한대 값으로 설정
			
			// 적색 정점들에 가장 가까운 청색 정점을 찾는다
			for (int b = 0; b < n; b++)
			{
				if(isBlue[b])			// 청색 정점이면 
				{
					if(W[b][near[b]] < minVal)
					{
						minVal = W[b][near[b]];		// minVal 값 갱신
						newRed = b;
					}
				}
			}
			
			isBlue[newRed] = false;		// 청색 정점 newRed를 적색으로 변경
			
			// 가중치가 가장 작은 간선을 T에 추가 
			System.out.println((char)(near[newRed] + 'a') + " - " + (char)(newRed + 'a') + "\t  " + W[newRed][near[newRed]]);

			// 청색 정점에 가장 가까운 적색 정점을 새로이 적색이 된 정점을 반영하여 갱신
			for (int b = 0; b < n; b++)
			{
				if(isBlue[b])
				{
					if(W[b][newRed] < W[b][near[b]])
					{
						near[b] = newRed;						
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{

		PrimeMST mst = new PrimeMST();

		int W[][] = new int[][]	// 가중치 행렬
		{
				{ 0, 2, INF, INF, 4 },
				{ 2, 0, 8, INF, 4 },
				{ INF, 8, 0, 7, 6 },
				{ INF, INF, 7, 0, 3 },
				{ 4, 4, 6, 3, 0 },				
		};
		
		mst.primMST(W, 5);

	}

}
