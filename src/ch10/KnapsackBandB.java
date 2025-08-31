package ch10;

import java.util.PriorityQueue;

/**
 * 분기 한정을 이용하여 배낭 채우기 문제를 해결하는 알고리즘
 * @author 김기태
 *
 */
public class KnapsackBandB {

	private int maxValue;  	// 현재까지 찾은 최고 해의 값
	private int N;			// 물건들의 수
	private int C;			// 배낭의 용량
	private int[] Wt;		// 각 물건의 무게를 저장하는 배열
	private int[] Val;		// 각 물건의 가치를 저장하는 배열
	
	private PriorityQueue<Node> queue;  // 상태 공간 트리를 대신하는 우선 순위 대기열
	
	/**
	 * 생성자
	 * 객체 변수들의 값들을 주어진 값으로 초기화하면서 우선 순위 대기열을 만든다
	 * @param num
	 * @param wt
	 * @param val
	 * @param cap
	 */
	public KnapsackBandB(int num, int[] wt, int[] val, int cap)
	{
		queue = new PriorityQueue<>();			// 우선 순위 대기열을 만든다
		maxValue = 0;
		N = num;
		C = cap;
		Wt = wt;
		Val = val;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : N개의 물건들 중에서 배낭의 용량 C를 초과하지 않고 배낭에 넣을 수 있는 물건들의 최대 가치를 계산한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @return
	 */
	public int knapsack()
	{
		Node root = new Node();
		int bound = computeBound(root);			// 한계값 계산 
		root.setBound(bound);					// 루트노드의 한계값 설정 
		
		// 루트 노드를 queue(우선 순위 대기열)에 집어 넣는다
		queue.add(root);
		
		// queue가 비어 있지 않은 동안 반복한다
		while(!queue.isEmpty())
		{
			Node temp = queue.remove();			// 최대 한계값을 가진 노드 temp를 queue에서 끄집어 낸다
			
			if (temp.getBound() > maxValue)		// 노드 temp가 유망하면 확장한다
			{
				// 다음 물건을 넣는 경우에는 노드 u를 자식 노드로 만든다
				Node u = new Node();
				u.setLevel(temp.getLevel() + 1); // 레벨 증가 
				u.setWeight(temp.getWeight() + Wt[temp.getLevel()]);	// 무게 설정 - Wt : 무게가 저장된 배열
				u.setValue(temp.getValue() + Val[temp.getLevel()]);	    // 가치 설정 - Val : 가치가 저장된 배열 
				
				if(u.getWeight() <= C && u.getValue() > maxValue) 
				{	// maxValue를 더 나은 해의 값으로 바꾼다
					maxValue = u.getValue();					
				}
				
				u.setBound(computeBound(u));	// 자식 노드의 한계값을 계산한다
				
				if(u.getBound() > maxValue)
				{
					queue.add(u);				// u가 유망하므로 queue에 집어 넣는다
				}
				
				// 다음 물건을 넣지 않는 경우에는 노드 w를 자식 노드로 만든다
				Node w = new Node();
				w.setLevel(temp.getLevel() + 1);
				w.setWeight(temp.getWeight());
				w.setValue(temp.getValue());
				
				w.setBound(computeBound(w));	// 자식 노드의 한계값을 계산한다. 
				
				if(w.getBound() > maxValue) {
					queue.add(w);				// w가 유망하므로 queue에 집어 넣는다
				}
			}
		}
		
		return maxValue;
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 해당 노드의 한계값을 계산한다. 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 * @return
	 */
	public int computeBound(Node node)
	{
		if(node.getWeight() >= C) 		// 노드의 무게가 배낭보다 큰 경우 
		{
			return 0;
		}
		else if(node.getLevel() < N)	// 물건수보다 작은 경우 한계값 계산 
		{
			return node.getValue() + (C - node.getWeight()) * (Val[node.getLevel()]/Wt[node.getLevel()]);			
		}
		else 
		{
			return node.getValue();		// 더이상 선택할 물건이 없는 경우 
		}

	}

	public static void main(String[] args) 
	{
		int[] wt = {12, 14, 15};	// 물건들의 무게를 저장하는 배열
		int[] val = {72, 70, 60};	// 물건들의 가치를 저장하는 배열
		
		// 객체 변수들의 값들을 초기화하면서 KnapsackBandB 객체를 생성한다
		KnapsackBandB kbb = new KnapsackBandB(3, wt, val, 30);

		// 분기 한정을 이용하여 배낭에 넣을 수 있는 물건들의 최대 가치를 계산한 후 출력한다
		System.out.println("배낭에 넣을 수 있는 물건들의 최대 가치 = " + kbb.knapsack());
	}

}
