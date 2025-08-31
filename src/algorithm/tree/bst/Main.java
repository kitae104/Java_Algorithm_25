package algorithm.tree.bst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);

        System.out.println("\n\n전위 순회");
        bst.preOrder(bst.getRoot());

        System.out.println("\n\n중위 순회");
        bst.inOrder(bst.getRoot());

        System.out.println("\n\n후위 순회");
        bst.postOrder(bst.getRoot());

        System.out.println("\n\n레벨 순회");
        bst.levelOrder(bst.getRoot());

        System.out.println("\n\n트리 검색");
        //System.out.println("검색하려는 값을 입력하세요 :");
        //Scanner sc = new Scanner(System.in);
        //int findValue = sc.nextInt();
        bst.search(bst.getRoot(), 40);
        //sc.close();

        System.out.println("\n\n트리 삭제");
        bst.deleteNode(bst.getRoot(), 90);

        System.out.println("\n\n레벨 순회");
        bst.levelOrder(bst.getRoot());

    }
}
