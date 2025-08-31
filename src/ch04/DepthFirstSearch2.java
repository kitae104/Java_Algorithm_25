package ch04;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 주어진 무방향 그래프를 깊이 우선 탐색으로 순회한다
 * </pre>
 * 
 * @author : 김기태
 */
public class DepthFirstSearch2 {

	public static void main(String[] args) {

		// 정점들을 표현한다 - 목록 리스트로 생성
		Node[] node = new Node[6];

		for (int i = 0; i < 6; i++) {
			node[i] = new Node(i + 1);
		}

		// 인접 목록 리스트로 생성
		node[0].addNeighbours(node[1]);
		node[0].addNeighbours(node[2]);
		node[0].addNeighbours(node[4]);
		node[1].addNeighbours(node[0]);
		node[1].addNeighbours(node[2]);
		node[2].addNeighbours(node[0]);
		node[2].addNeighbours(node[1]);
		node[2].addNeighbours(node[3]);
		node[2].addNeighbours(node[4]);
		node[3].addNeighbours(node[2]);
		node[3].addNeighbours(node[5]);
		node[4].addNeighbours(node[0]);
		node[4].addNeighbours(node[2]);
		node[5].addNeighbours(node[2]);
		node[5].addNeighbours(node[3]);

		// 인접 목록 리스트 출력하기
		System.out.println("인접 목록 리스트 출력하기");
		Arrays.stream(node).forEach(n -> {
			System.out.print(n.getInfo() + " : ");
			List<Node> neighbours = n.getNeighbours();
			neighbours.stream().forEach(neighbour -> {
				System.out.print(neighbour.getInfo() + " ");
			});
			System.out.println();
		});

		// 주어진 무방향 그래프를 깊이 우선 탐색으로 순회한다
		System.out.println("재귀를 사용한 깊이 우선 탐색 실행 결과");
		dfs(node[0]);
	}

	/**
	 * <pre>
	 * 1. 개요 : 정점 node에 연결된 방문하지 않은 정점들을 깊이 우선 탐색을 
	 * 이용하여 재귀적으로 방문한다
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 */
	private static void dfs(Node node) {
		
		System.out.print(node.getInfo() + " : ");	// 정점 대응된 데이터를 출력한다
		node.setVisited(true);						// 해당 노드를 방문함으로 표시
		
		List<Node> neighbours = node.getNeighbours();	// 정점에 인접한 연결 목록 
		neighbours.stream().forEach(n -> {
			System.out.print(n.getInfo() + "(" + n.isVisited() + ") ");	// 인접 노드 정보와 방문 여부 출력
		});
		System.out.println();

		for (Node n : neighbours) {
			if(n != null && !n.isVisited()) {
				System.out.println("===> 선택된 노드 : " + n.getInfo());
				dfs(n);
				System.out.println("<== 재귀 호출 후 : " + n.getInfo());
			}
		}
	}
}
