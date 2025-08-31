package ch10;

public class Node implements Comparable<Node> {
	private int level;  // 노드의 수준
	private int weight;	// 선택된 물건들의 총 무게
	private int value;	// 선택된 물건들의 총 가치
	private int bound;	// 한계값

	public Node() {
    	this.level = 0;
    	this.weight = 0;
    	this.value = 0;
    	this.bound = 0;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}
	
	/**
	 * bound(한계값)이 큰 노드가 우선 순위가 높다
	 */
	@Override
	public int compareTo(Node other) {
		// maxheap
    	if(bound < other.bound){
        	return 1;
    	} else if(bound > other.bound){
			return -1;
    	} else {
            return 0;
    	}
	}
}
