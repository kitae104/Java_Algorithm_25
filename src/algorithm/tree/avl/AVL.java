package algorithm.tree.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    private BinaryNode root;

    public AVL(){
        this.root = null;
    }

    // 전위 순회
    public void preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    // 중위 순회
    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    // 후위 순회
    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();   // 큐 생성
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            System.out.print(currentNode.getValue() + " ");
            if(currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());   // 큐에 왼쪽 노드 추가
            }
            if(currentNode.getRight() != null){
                queue.add(currentNode.getRight());  // 큐에 오른쪽 노드 추가
            }
        }
    }

    // 찾기 메소드
    public BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.println("찾는 값 " + value + "가 AVL 트리에 없습니다.");
            return null;
        } else if(node.getValue() == value){
            System.out.println("찾는 값 " + value + "가 AVL 트리에 있습니다.");
            return node;
        } else if(node.getValue() > value){
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }
}
