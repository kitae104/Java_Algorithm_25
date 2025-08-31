package algorithm.tree.avl;

import lombok.Data;

@Data
public class BinaryNode {
    private int value;
    private int height;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
