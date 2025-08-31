package algorithm.tree.binarytree.array;

public class Main {
    public static void main(String[] args) {
        BinaryTreeArray binaryTree = new BinaryTreeArray(9);
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.insert("N7");
        binaryTree.insert("N8");
        binaryTree.insert("N9");

        System.out.println("\n\n전위 순회");
        binaryTree.preOrder(1);

        System.out.println("\n\n중위 순회");
        binaryTree.inOrder(1);

        System.out.println("\n\n후위 순회");
        binaryTree.postOrder(1);

        System.out.println("\n\n레벨 순회");
        binaryTree.levelOrder();

        int index = binaryTree.search("N5");
        System.out.println("N5 의 인덱스는 " + index + " 입니다.");

        binaryTree.delete("N5");
        binaryTree.levelOrder();
    }
}
