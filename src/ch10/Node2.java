package ch10;

/**
 * 상태 공간 트리의 노드를 나타낸다
 * @author 김기태
 *
 */
public class Node2 implements Comparable<Node2>
{
	private int personNumber;  		// 사람의 번호
	private int jobNumber;			// 일의 번호
	private int bound;				// 한계값
	private int sumAssignedCost;	// 현재까지 배정된 일들의 비용들의 합
	private Node2 parent;			// 현 노드의 부모 노드
	private boolean[] assigned = new boolean[10]; // 사람들에 일들의 배정 여부를 저장하는 배열
	
	/**
	 * 생성자 
	 * 상태 공간 트리의 노드를 사람 x에 일 y를 배정하면서 만든다
	 * @param N 배정 숫자
	 * @param x 사람 숫자 
	 * @param y 작업 숫자 
	 * @param assigned 사람들에 일들의 배정 여부를 저장하는 배열 
	 * @param parent 부모 노드 
	 */
	public Node2(int N, int x, int y, boolean[] assigned, Node2 parent)
	{
		this.personNumber = x;
		this.jobNumber = y;
		this.parent = parent;
		
		// 부모 노드의 일 배정 결과를 저장한다
		for (int i = 0; i < N; i++)
		{
			this.assigned[i] = assigned[i];
		}
		
		// 루트 노드가 아니면 일 y를 배정한다
		if(y >= 0) 
		{
			this.assigned[y] = true;
		}
	}

	public int getPersonNumber()
	{
		return personNumber;
	}

	public void setPersonNumber(int personNumber)
	{
		this.personNumber = personNumber;
	}

	public int getJobNumber()
	{
		return jobNumber;
	}

	public void setJobNumber(int jobNumber)
	{
		this.jobNumber = jobNumber;
	}

	public int getBound()
	{
		return bound;
	}

	public void setBound(int bound)
	{
		this.bound = bound;
	}

	public int getSumAssignedCost()
	{
		return sumAssignedCost;
	}

	public void setSumAssignedCost(int sumAssignedCost)
	{
		this.sumAssignedCost = sumAssignedCost;
	}

	public Node2 getParent()
	{
		return parent;
	}

	public void setParent(Node2 parent)
	{
		this.parent = parent;
	}

	public boolean getAssigned(int i)
	{
		return assigned[i];
	}

	public void setAssigned(int i, boolean b)
	{
		assigned[i] = b;
	}

	/**
	 * bound(한계값)이 작은 노드가 우선 순위가 높다
	 */
	@Override
	public int compareTo(Node2 other)
	{
		if(bound > other.bound)
		{
			return 1;
		}
		else if(bound < other.bound)
		{
			return -1;
		} 
		else 
		{
			return 0;
		}		
	}

	public boolean[] getAssigned()
	{
		return assigned;
	}
}
