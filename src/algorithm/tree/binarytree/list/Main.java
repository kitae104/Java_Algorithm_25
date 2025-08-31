package algorithm.tree.binarytree.list;

public class Main {
    public static void main(String[] args) {
        BinaryTreeLinkedList binaryTree = new BinaryTreeLinkedList();

        // 리프노드 먼저 만들어어야 관리가 편함
        BinaryNode N9 = new BinaryNode("5");
        BinaryNode N8 = new BinaryNode("3");
        BinaryNode N7 = new BinaryNode("6");
        BinaryNode N6 = new BinaryNode("2");
        BinaryNode N5 = new BinaryNode("7");
        BinaryNode N4 = new BinaryNode("+", N8, N9);
        BinaryNode N3 = new BinaryNode("-", N6, N7);
        BinaryNode N2 = new BinaryNode("+", N4, N5);
        BinaryNode N1 = new BinaryNode("*", N2, N3);

        binaryTree.setRoot(N1);

        System.out.println("Binary Tree : 전위 순회 ");
        binaryTree.preOrder(binaryTree.getRoot());

        System.out.println("\n\nBinary Tree : 중위 순회");
        binaryTree.inOrder(binaryTree.getRoot());

        System.out.println("\n\nBinary Tree : 후위 순회");
        binaryTree.postOrder(binaryTree.getRoot());

        System.out.println("\n\nBinary Tree : 레벨 순회");
        binaryTree.levelOrder(binaryTree.getRoot());

        System.out.println("\n\nBinary Tree : 값 검색하기 ");
        binaryTree.search(binaryTree.getRoot(), "/");
    }


}
