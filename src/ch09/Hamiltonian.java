package ch09;

/**
 * <pre>
 * 연결된 무방향 그래프의 모든 해밀토니안 회로를 찾기
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 31.
 * @Version	:
 */
public class Hamiltonian
{
	private int n;					// 그래프의 정점들의 수
	private int[] path;				// 해밀토니안 회로내의 정점들을 저장하는 배열
	
	public Hamiltonian(int n, int cnt)
	{
		this.n = n;
		path = new int[cnt];
	}
	
	public void setStart(int i)
	{
		path[0] = i;				// 시작 정점 설정	
	}

	/**
	 * <pre>
	 * 1. 개요 : 연결된 무방향그래프 G내의 모든 해밀토니안 회로를 찾아서 출력한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param G : 인접행렬
	 * @param i : 정점 
	 */
	public void findHamiltonian(int[][] G, int i)
	{
		if(valid(G, i))			// 유효한지 찾기 
		{
			if(i == n - 1)		// 찾은 해밀토니안 회로 path[0..n-1]을 출력한다
			{
				System.out.print("찾은 해밀토니안 회로: ");
				for (int j = 0; j < n; j++)
				{
					System.out.print(path[j] + " -> ");
				}
				System.out.println(path[0]); 			// 시작점으로 
				return;
			}
			else 				// i 번째로 방문할 정점으로 시작 정점을 제외한 모든 정점을 시도해 본다
			{
				for (int j = 2; j <= n; j++)
				{
					path[i + 1] = j;
					findHamiltonian(G, i + 1);
				}
			}
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 경로상의 i 번째 정점이 유효한 선택인지를 확인한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param G 인접행렬 
	 * @param i 정점의 개수
	 * @return
	 */
	public boolean valid(int[][] G, int i)
	{
		// 마지막 정점이 첫 번째 정점과 인접하지 않은 경우
		if(i == n - 1 && G[path[n-1] - 1][path[0] - 1] == 0)
		{	
			return false;
		}
		// i 번째 정점이 (i-1)번째 정점과 인접하지 않은 경우
		else if(i > 0 && G[path[i-1] -1][path[i] - 1] == 0)
		{
			return false;
		}
		// i 번째 정점이 이미 선택되었는지를 확인한다
		else 
		{
			int j = 1;
			while(j < i)
			{
				if(path[i] == path[j])
				{
					return false;
				}
				j++;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		Hamiltonian hamilton = new Hamiltonian(4, 10);
		
		// 인접 행렬
		int[][] G = {
				{0, 1, 1, 1},
	            {1, 0, 0, 1},
	            {1, 0, 0, 1},
	            {1, 1, 1, 0}				
		};
		
		hamilton.setStart(1);
		hamilton.findHamiltonian(G, 0);	// 해밀토니안 회로를 찾아서 출력한다. 
	}
	
}
