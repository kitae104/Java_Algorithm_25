package ch10;

import java.util.PriorityQueue;

/**
 * 
 * <pre>
 * 분기 한정을 이용하여 일 배정 문제를 해결하는 프로그램
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 9. 4.
 * @Version	:
 */
public class JobAssignmentBandB
{

	private int N;						// 사람들의 수
	private int[][] costMatrix;			// 비용 행렬
	private PriorityQueue<Node2> queue;  // 상태 공간 트리를 대신하는 우선 순위 대기열
	
	/**
	 * 생성자<br> 
	 * 객체 변수들의 값들을 주어진 값으로 초기화하면서 JobAssignmentBandB 객체를 생성한다
	 * @param num 사람들 수 
	 * @param cost 비용 배열 
	 */
	public JobAssignmentBandB(int num, int[][] costMatrix)
	{
		// 살아 있는 노드들을 포함하는 우선 순위 대기열을 만든다
		queue = new PriorityQueue<>();
		
		N = num;
		this.costMatrix = costMatrix;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 일들의 최소 배정 비용을 계산한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @return
	 */
	public int findMinCost()
	{		
		boolean[] assigned = new boolean[N];	// 사람들에 일들의 배정 여부를 저장하는 배열 
		
		// 상태 공간 트리의 루트 노드의 값들을 초기화하면서 만든다
		for (int i = 0; i < N; i++)
		{
			assigned[i] = false;
		}
		
		Node2 root = new Node2(N, -1, -1, assigned, null);
		root.setSumAssignedCost(0);
		
		// 루트 노드의 한계값을 계산한다
		root.setBound(computeBound(-1, -1, root.getAssigned()));
		
		queue.add(root);	// 루트 노드를 queue(우선 순위 대기열)에 집어 넣는다
		
		// queue가 비어 있지 않은 한 한계값이 최소인 살아 있는 노드를 찾아서
		// 그 노드의 자식 노드들을 queue에 추가한다.
		while(!queue.isEmpty())
		{
			// 최소 한계값을 가진 노드 minNode를 queue에서 끄집어 낸다
			Node2 minNode = queue.remove();
			
			int i = minNode.getPersonNumber() + 1;	// i는 일을 배정할 다음 사람을 나타낸다
			
			// 모든 사람들에게 일들이 배정되면 배정 결과를 출력하고 최소 배정 비용을 반환한다
			if(i == N)
			{
				printAssignment(minNode);				// 출력 
				return minNode.getSumAssignedCost();	// 최소 비용 반환 
			}
			
			// 사람 i에 배정 가능한 일을 배정하는 모든 자식 노드를 만들어 queue에 추가한다
			for (int j = 0; j < N; j++)
			{
				if(!minNode.getAssigned(j))			// 일 j가 배정되지 않았은지 확인
				{
					// 사람 i에 일 j를 배정하면서 자식 노드를 만든다
					Node2 child = new Node2(N, i, j, minNode.getAssigned(), minNode);
					
					// 배정된 일들의 총 비용에 새로 배정된 일의 비용을 더한다
					child.setSumAssignedCost(minNode.getSumAssignedCost() + costMatrix[i][j]);
					
					// 새 자식 노드의 한계값을 계산한다
					child.setBound(child.getSumAssignedCost() + computeBound(i, j, child.getAssigned()));
					
					// 새 자식 노드를 queue에 추가한다. 
					queue.add(child);
				}
			}
		}
		
		return -1;		// 컴파일 오류가 나지 않게 하기 위해 추가
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 사람 x를 일 y에 배정한 후 일들이 배정되지 않은 모든 사람들에게 
	 *           남은 일들을 배정하는 데 드는 총 비용의 하한을 계산한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param x 사람 
	 * @param y 일
	 * @param assigned
	 * @return
	 */
	public int computeBound(int x, int y, boolean[] assigned)
	{
		int bound = 0;	// 일들이 배정되지 않은 모든 사람들에게 남은 일들을 배정하는 총 비용의 하한
		
		for (int i = x + 1; i < N; i++)
		{
			int minCost = Integer.MAX_VALUE;		// 최소 비용에 대한 초기화
			int minIndex = -1;
			
			// 사람 i에 일을 배정하는 최소 비용을 찾는다
			for (int j = 0; j < N; j++)
			{
				if(!assigned[j] && j != y && costMatrix[i][j] < minCost)
				{
					minIndex = j;					// 일 번호 저장
					minCost = costMatrix[i][j];		// 비용 저장 
				}
			}
			
			bound = bound + minCost;	// 다음 사람에게 배정 가능한 일의 최소 비용을 더한다. 				
		}
		return bound;
	}

	public void printAssignment(Node2 minNode)
	{
		if(minNode == null)
		{
			return;
		}
		
		printAssignment(minNode.getParent());
		
		if(minNode.getPersonNumber() != -1)
		{
			System.out.println("사람 " + (minNode.getPersonNumber() + 1)
	                   + "을 일 " + (minNode.getJobNumber() + 1) + "에 배정한다.");
		}
	}

	
	public static void main(String[] args)
	{
		// 일 배정 비용을 저장하는 배열
		// costMatrix[i][j]는 사람 i에 일 j를 배정하는 비용을 나타낸다
		int[][] costMatrix = 
			{
					{5, 3, 6, 7}, 
					{4, 6, 2, 5}, 
					{6, 3, 5, 4}, 
					{9, 6, 8, 5}
			};
		
		// 객체 변수들의 값들을 초기화하면서 JobAssignmentBandB 객체를 생성한다
		JobAssignmentBandB jabb = new JobAssignmentBandB(4, costMatrix);

		// 분기 한정을 이용하여 일들의 최소 배정 비용을 계산한 후 출력한다
		System.out.println("\n최소 배정 비용 = " + jabb.findMinCost());
	}
}
