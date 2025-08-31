package QnA;

import algorithm.graph.basic.list.GraphNode;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<GraphNode> sList = new ArrayList<>();
        sList.add(new GraphNode("A", 0));
        sList.add(new GraphNode("B", 1));
        sList.add(new GraphNode("C", 2));
        sList.add(new GraphNode("D", 3));

        GraphNode a = sList.get(0);
    }
}
