package algorithm.graph.basic.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>(); // 그래프 노드 리스트
    int[][] adjacencyMatrix; // 인접행렬

    // 생성자
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    // 무방향 그래프 간선 추가
    public void addUndirectedEdge(int i, int j){
        i = i - '1';
        j = j - '1';
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    /**
     * 그래프 인접행렬 출력
     * @return
     */
    @Override
    public String toString() {
        System.out.println("= 그래프 인접행렬 =");
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).getName() + "  ");
        }
        sb.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).getName() + "  ");
            for (int j : adjacencyMatrix[i]) {
                sb.append(j + "  ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * 현재 노드에 인접한 노드들을 반환
     * @param node
     * @return
     */
    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
        int nodeIndex = node.getIndex();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }
    
    /**
     * BFS 탐색
     * @param node
     */
    public void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);    // 큐에 노드 추가

        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(); // 큐에서 노드를 꺼냄
            currentNode.setVisited(true); // 현재노드 방문처리
            System.out.print(currentNode.getName() + " ");  // 현재노드 출력
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode); // 현재노드에 인접한 노드들을 가져옴
            for (GraphNode neighbor : neighbors) {
                if(!neighbor.isVisited()) {
                    queue.add(neighbor);        // 인접한 노드들을 큐에 추가
                    neighbor.setVisited(true);  // 인접한 노드 방문처리(중복방지)
                }
            }
        }
    }
    
    public void bfs() {
        for (GraphNode node : nodeList) {
            if(!node.isVisited()){
                bfsVisit(node);
            }
        }
    }

    /**
     * 인접 행렬에서 DFS 탐색
     * @param node
     */
    public void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<GraphNode>();    // 스택 생성
        stack.push(node);   // 스택에 노드 추가

        // 스택이 빌 때까지 반복
        while(!stack.isEmpty()) {
            GraphNode currentNode = stack.pop(); // 스택에서 노드를 꺼냄
            currentNode.setVisited(true); // 현재노드 방문처리
            System.out.print(currentNode.getName() + " ");  // 현재노드 출력
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode); // 현재노드에 인접한 노드들을 가져옴
            for (GraphNode neighbor : neighbors) {
                if(!neighbor.isVisited()) {
                    stack.push(neighbor);       // 인접한 노드들을 스택에 추가
                    neighbor.setVisited(true);  // 인접한 노드 방문처리(중복방지)
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if(!node.isVisited()){
                dfsVisit(node);
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
        i = i - '1';
        j = j - '1';
        adjacencyMatrix[i][j] = 1;
    }

    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbors = getNeighbors(node); // 현재 노드에 인접한 노드들을 가져옴
        for (GraphNode neighbor : neighbors) {
            if(!neighbor.isVisited()){  // 방문하지 않은 노드라면
                topologicalVisit(neighbor, stack);  // dfs 탐색
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
