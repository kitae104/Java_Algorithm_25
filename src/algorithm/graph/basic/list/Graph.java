package algorithm.graph.basic.list;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@Data
public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>(); // 그래프 노드 리스트

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    // 무방향 그래프 간선 추가
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);  // i번째 노드
        GraphNode second = nodeList.get(j); // j번째 노드
        first.getNeighbors().add(second);   // i번째 노드의 이웃에 j번째 노드 추가
        second.getNeighbors().add(first);   // j번째 노드의 이웃에 i번째 노드 추가
    }

    // 그래프 출력 함수
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GraphNode graphNode : nodeList) {
            sb.append(graphNode.getName()).append("의 인접리스트 : ");
            for (int j = 0; j < graphNode.getNeighbors().size(); j++) {
                if (j == graphNode.getNeighbors().size() - 1) {
                    sb.append(graphNode.getNeighbors().get(j).getName());   // 마지막 원소인 경우
                } else {
                    sb.append(graphNode.getNeighbors().get(j).getName()).append(" -> ");    // 계속 이어지는 경우
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * 인접 리스트를 이용한 bfs 탐색
     * @param node
     */
    public void bfsVisit(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node); // 노드 추가

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(); // 큐에서 노드 제거
            currentNode.setVisited(true); // 방문한 노드로 표시
            System.out.print(currentNode.getName() + " "); // 현재 노드 출력

            for(GraphNode neighbor : currentNode.getNeighbors()){
                if(!neighbor.isVisited()){
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    public void bfs(){
        for(GraphNode node : nodeList){ // 모든 노드에 대해
            if(!node.isVisited()){      // 노드가 방문하지 않은 노드라면
                bfsVisit(node);         // bfs 탐색
            }
        }
    }

    /**
     * 인접 리스트를 이용한 dfs 탐색
     * @param node
     */
    public void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<GraphNode>();    // 스택 생성
        stack.push(node); // 노드 추가

        // 스택이 빌 때까지 반복
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop(); // 스택에서 노드 제거
            currentNode.setVisited(true); // 방문한 노드로 표시
            System.out.print(currentNode.getName() + " "); // 현재 노드 출력

            // 현재 노드의 이웃에 대해 방문하지 않은 노드가 있다면 스택에 추가
            for(GraphNode neighbor : currentNode.getNeighbors()){
                if(!neighbor.isVisited()){      // 방문하지 않은 노드라면
                    stack.push(neighbor);       // 스택에 추가
                    neighbor.setVisited(true);  // 방문한 노드로 표시
                }
            }
        }
    }

    public void dfs(){
        for(GraphNode node : nodeList){ // 모든 노드에 대해
            if(!node.isVisited()){      // 노드가 방문하지 않은 노드라면
                dfsVisit(node);         // dfs 탐색
            }
        }
    }
    
    //===============================    
    // Topolicical Sort
    //===============================

    /**
     * 방향을 가지는 간선 추가
     * @param i
     * @param j
     */
    public void addDirectedEdge(int i, int j) {
        i = i - 'A';
        j = j - 'A';
        GraphNode first = nodeList.get(i);  // i번째 노드
        GraphNode second = nodeList.get(j); // j번째 노드
        first.getNeighbors().add(second);   // i번째 노드의 이웃에 j번째 노드 추가
    }
    
    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        for (GraphNode neigbor : node.getNeighbors()) { // 현재 노드의 이웃에 대해
            if(!neigbor.isVisited()){   // 방문하지 않은 노드라면
                topologicalVisit(neigbor, stack);  // 재귀적으로 방문
            }
        }
        // 더 이상 이웃이 없는 경우라면 스택에 추가
        node.setVisited(true);  // 방문한 노드로 표시
        stack.push(node);       // 스택에 추가
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<GraphNode>();    // 스택 생성
        for (GraphNode node : nodeList) {   // 모든 노드에 대해 --> 첫번째 노드로부터 탐색
            if(!node.isVisited()){  // 방문하지 않은 노드라면
                topologicalVisit(node, stack);  // dfs 탐색
            }
        }
        // 스택에 있는 노드들을 출력
        while(!stack.isEmpty()){
            System.out.print(stack.pop().getName() + " ");
        }
    }
}
