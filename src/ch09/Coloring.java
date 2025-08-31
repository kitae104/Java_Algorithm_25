package ch09;

/**
 * 무방향그래프에서 m개의 색만을 사용하여 인접한 정점들이 다른 색이 되도록
 * 모든 정점을 색칠하는 모든 방법을 출력한다.
 * @author 김기태
 *
 */
public class Coloring {
	
	private int N;  		// 그래프의 정점들의 수
	private int m;			// 색들의 수
	private int[] vcolor; 	// 정점들에 칠해진 색들의 배열
	private String[] colors = {"", "빨", "주", "노", "초"};		// 추가
	
	/**
	 * 생성자 
	 * 
	 * @param vertext	정점 수
	 * @param color		색상 수
	 * @param n			배열 크기 
	 */
	public Coloring(int vertext, int color, int n) 
	{
		N = vertext;
		m = color;
		vcolor = new int[n];
	}
	
	/**
	 * 무방향그래프 G의 정점들을 색칠하는 모든 방법을 출력
	 * @param G 인접 행렬
	 * @param i 시작 정점
	 */
	public void vertexColoring(int[][] G, int i) 
	{
		if(valid(G, i))
		{
			// 정점들에 칠해진 색들의 배열 vcolor[1..N]을 출력한다
			if(i == N)
			{
				System.out.print("색칠 하기: ");
				for (int j = 1; j <= N; j++) 
				{
					//System.out.print("정점 " + j + "의 색 = " + vcolor[j] + " || ");
					//System.out.print("정점 " + j + "의 색 = " + colors[vcolor[j]] + " || ");
					System.out.print(j + "("+ colors[vcolor[j]] + ") ");
				}
				System.out.println();
				return;
			}
			// 다음 정점에 모든 색을 시도해 본다
			else 	
			{
				for (int color = 1; color <= m; color++) {
					vcolor[i + 1] = color;
					vertexColoring(G, i + 1);
				}
			}
		}
	}
	
	/**
	 * 정점 i에 칠해진 색이  유효한지 확인한다
	 * @param G
	 * @param i
	 * @return
	 */
	public boolean valid(int[][] G, int i) 
	{
		int j = 1;
		
		while(j < i)
		{	// 정점 i의 색이 인접한 정점(들)의 색과 같은지를 확인한다
			if(G[i-1][j-1] == 1 && vcolor[i] == vcolor[j])
			{
				return false;
			}
			j++;
		}		
		return true;
	}

	public static void main(String[] args) 
	{
		Coloring col = new Coloring(5, 3, 10);
		
		// 그래프는 인접 행렬로 나타낸다
    	int graph[][] = 
    	{
    		{0, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
    	
    	col.vertexColoring(graph, 0);
    	
	}

}
