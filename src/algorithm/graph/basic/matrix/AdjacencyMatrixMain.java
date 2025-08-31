package algorithm.graph.basic.matrix;

import java.util.ArrayList;

public class AdjacencyMatrixMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("1", 0));
        nodeList.add(new GraphNode("2", 1));
        nodeList.add(new GraphNode("3", 2));
        nodeList.add(new GraphNode("4", 3));
        nodeList.add(new GraphNode("5", 4));
        nodeList.add(new GraphNode("6", 4));
        nodeList.add(new GraphNode("7", 4));

        Graph g = new Graph(nodeList);

        g.addDirectedEdge('1', '2');
        g.addDirectedEdge('1', '3');
        g.addDirectedEdge('1', '7');
        g.addDirectedEdge('2', '3');
        g.addDirectedEdge('2', '4');
        g.addDirectedEdge('3', '5');
        g.addDirectedEdge('4', '3');
        g.addDirectedEdge('5', '7');
        g.addDirectedEdge('6', '5');
        g.addDirectedEdge('7', '6');
        g.addDirectedEdge('6', '4');

        System.out.println("==== 인접 행렬 ====");
        System.out.println(g);

        System.out.println("==== BFS ====");
        g.bfs();
        System.out.println();

        // visited 초기화 - 이전 작업에 의해 노드가 방문되었으므로 초기화 필요
        for (GraphNode node : nodeList) {
            node.setVisited(false);
        }

        System.out.println("\n==== DFS ====");
        g.dfs();
    }
}
