package ch04;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 너비우선 탐색
 * 
 * @author 김기태
 *
 */
public class BreadthFirstSearch2 {
	private Queue<Node> queue;	// 방문할 정점들을 저장하는 큐
	
	public BreadthFirstSearch2() {
		queue = new LinkedList<Node>();
	}
	
	public void bfs(Node v) {
		
		v.setVisited(true);		// v를 '방문함'으로 표시한다
		queue.add(v);			// v를 큐에 추가한다
		System.out.println(v.getInfo() + " : 노드 방문시 큐에 추가된 정점들");
		System.out.print("Queue : [");
		queue.stream().forEach(node -> System.out.print(node.getInfo() + "(" + node.isVisited() + ")"));
		System.out.println("]");
		
		while(!queue.isEmpty()) {			// 큐가 비어 있지 않은 동안
			
			Node element = queue.remove();	// 큐의 맨 앞에 있는 정점을 끄집어 내어 element에 저장한다
			System.out.println("Queue에서 [" + element.getInfo() + "] 제거");			// 노드 출력
			
			List<Node> neighbours = element.getNeighbours();	// element에 인접한 정점들의 연결 목록
			System.out.print("[" + element.getInfo() + "]의 이웃 : ");
			neighbours.stream().forEach(node -> System.out.print(" -> " + node.getInfo() + "(" + node.isVisited() + ")" ));	// 인접 노드 정보와 방문 여부 출력
			System.out.println();

			// element에 인접한 방문하지 않은 모든 정점들에 대해 너비 우선 탐색을 수행
			for (int i = 0; i < neighbours.size(); i++) {
				Node w = neighbours.get(i);
				//System.out.println("정점 [" + w.getInfo() + "]에 대한 처리");
				if(w != null && !w.isVisited()) {				// w가 '방문 안함'으로 표시되어 있는 경우
					w.setVisited(true);							// 해당 노드 방문
					queue.add(w);								// w를 큐에 추가한다
					System.out.println("Queue에 [" + w.getInfo() + "] 추가");
					System.out.print("현재 Queue : ");
					queue.stream().forEach(node -> System.out.print(node.getInfo() + "(" + node.isVisited() + ") "));
					System.out.println();
				}
			}			
		}			
	}
	
	public static void main(String[] args) {
		// 정점들을 표현한다
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		// 간선들을 표현한다
		node1.addNeighbours(node2);
		node1.addNeighbours(node3);
		node1.addNeighbours(node5);
		node2.addNeighbours(node1);
		node2.addNeighbours(node3);
		node3.addNeighbours(node1);
		node3.addNeighbours(node2);
		node3.addNeighbours(node4);
		node3.addNeighbours(node5);
		node5.addNeighbours(node1);
		node4.addNeighbours(node3);
		node4.addNeighbours(node6);
		node5.addNeighbours(node1);
		node5.addNeighbours(node3);
		node6.addNeighbours(node3);
		node6.addNeighbours(node4);		

		BreadthFirstSearch2 bfsExample = new BreadthFirstSearch2();

		// 주어진 무방향 그래프를 너비 우선 탐색으로 순회한다
		System.out.println("너비 우선 탐색 실행 결과");
		bfsExample.bfs(node1);
	}
}
