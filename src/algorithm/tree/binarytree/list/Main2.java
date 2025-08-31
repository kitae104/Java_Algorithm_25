package algorithm.tree.binarytree.list;

public class Main2 {
    public static void main(String[] args) {
        BinaryTreeLinkedList binaryTree = new BinaryTreeLinkedList();
        binaryTree.insertNode("N1");
        binaryTree.insertNode("N2");
        binaryTree.insertNode("N3");
        binaryTree.insertNode("N4");
        binaryTree.insertNode("N5");
        binaryTree.insertNode("N6");
        binaryTree.insertNode("N7");
        binaryTree.insertNode("N8");
        binaryTree.insertNode("N9");
        //binaryTree.insertNode("N10");

        binaryTree.levelOrder(binaryTree.getRoot());
        System.out.println();
        binaryTree.deleteNode("N3");
        binaryTree.levelOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println(binaryTree.getDeepestNode().getValue());
    }
}
