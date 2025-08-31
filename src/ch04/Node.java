package ch04;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 그래프의 한 정점을 나타낸다.
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 16.
 * @Version	:
 */
public class Node {
	
	private int info;				// 정점에 대응된 데이터
	private boolean visited;		// 방문 여부
	private List<Node> neighbours;	// 정점에 인접한 정점들의 연결 목록

	/**
	 * 생성자 
	 * @param info
	 */
	public Node(int info) {
		this.info = info;
		this.visited = false;
		this.neighbours = new ArrayList<>();
	}

	/**
	 * <pre>
	 * 1. 개요 : 정점에 인접한 정점들의 연결 목록에 새 정점을 추가한다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 */
	public void addNeighbours(Node node) {
		neighbours.add(node);		
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
	
}
