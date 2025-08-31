package algorithm.graph.basic.list;

import java.util.ArrayList;

public class TopologicalSortListMain {
    public static void main(String[] args) {

        // 생성할 그래프는 topological2.png 참고
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));

        Graph g = new Graph(nodeList);

        g.addDirectedEdge('A', 'C');
        g.addDirectedEdge('B', 'C');
        g.addDirectedEdge('B', 'D');
        g.addDirectedEdge('C', 'E');
        g.addDirectedEdge('D', 'F');
        g.addDirectedEdge('E', 'H');
        g.addDirectedEdge('E', 'F');
        g.addDirectedEdge('F', 'G');

        System.out.println("==== 인접 리스트 ====");
        System.out.println(g);

        System.out.println("==== 위상 정렬 ====");
        g.topologicalSort();
    }
}
