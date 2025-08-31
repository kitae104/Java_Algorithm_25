package algorithm.tree.binarytree.list;

import lombok.Data;

@Data
public class BinaryNode {
    private String value;   // 데이터
    private BinaryNode left; // 왼쪽 자식 노드
    private BinaryNode right; // 오른쪽 자식 노드
    private int height; // 노드의 높이


    public BinaryNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public BinaryNode(String value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.height = 1;
    }
}
