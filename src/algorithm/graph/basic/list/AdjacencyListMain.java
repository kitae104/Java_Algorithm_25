package algorithm.graph.basic.list;

import java.util.ArrayList;

public class AdjacencyListMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph g = new Graph(nodeList);

        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        System.out.println("==== 인접 리스트 ====");
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
