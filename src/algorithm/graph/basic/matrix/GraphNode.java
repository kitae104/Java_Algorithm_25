package algorithm.graph.basic.matrix;

import lombok.Data;

@Data
public class GraphNode {
    private String name; // 노드 이름
    private int index;   // 노드 인덱스
    private boolean visited; // 방문 여부

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.visited = false;
    }
}
