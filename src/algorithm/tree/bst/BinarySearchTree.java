package algorithm.tree.bst;

import lombok.Data;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

@Data
public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {   // 새로운 노드를 만들어서 리턴
            BinaryNode newNode = new BinaryNode(value);
            System.out.println("값 : " + value + " 을 트리에 추가.");
            return newNode;
        } else if(value <= currentNode.getValue()){  // 왼쪽 서브트리로 이동
            currentNode.setLeft(insert(currentNode.getLeft(), value));
            return currentNode;
        } else {   // 오른쪽 서브트리로 이동
            currentNode.setRight(insert(currentNode.getRight(), value));
            return currentNode;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * 전위 순회
     * @param node
     */
    public void preOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 중위 순회
     * @param node
     */
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    /**
     * 후위 순회
     * @param node
     */
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    /**
     * 레벨 순회
     * @param node
     */
    public void levelOrder(BinaryNode node) {
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

    /**
     * 이진 탐색 트리에서 노드 검색
     * @param node 현재 노드
     * @param value 검색할 값
     */
    public BinaryNode search(BinaryNode node, int value) {
        if(node == null) {  // 노드가 null이면 null 리턴
            System.out.println("찾는 값 " + value + "가 트리에 없습니다.");
            return null;
        }
        if(node.getValue() == value) {  // 노드의 값이 찾는 값과 같으면 노드 리턴
            System.out.println("찾는 값 " + value + "이 트리에 있습니다.");
            return node;
        } else if(value < node.getValue()) { // 찾는 값이 현재 노드의 값보다 작으면 왼쪽 서브트리 탐색
            return search(node.getLeft(), value);
        } else {    // 찾는 값이 현재 노드의 값보다 크면 오른쪽 서브트리 탐색
            return search(node.getRight(), value);
        }
    }

    /**
     * 최소값을 갖는 노드 찾기
     * @param root
     * @return
     */
    public BinaryNode minimumNode(BinaryNode root){
        if(root.getLeft() == null){
            return root;
        } else {
            return minimumNode(root.getLeft());
        }
    }

    /**
     * BST 노드 삭제
     * @param root
     * @param value
     * @return
     */
    public BinaryNode deleteNode(BinaryNode root, int value){
        if(root == null){
            System.out.println("BST에서 해당 값을 찾지 못했습니다.");
            return null;
        }
        if(value < root.getValue()){   // 루트의 값보다 찾으려면 값이 작은 경우
            root.setLeft(deleteNode(root.getLeft(), value));
        } else if(value > root.getValue()){ // 찾으려는 값이 루트의 값보다 큰 경우
            root.setRight(deleteNode(root.getRight(), value));
        } else {
            if(root.getLeft() != null && root.getRight() != null){  // 양쪽 자식이 있는 경우
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.getRight());
                root.setValue(minNodeForRight.getValue());
                root.setRight(deleteNode(root.getRight(), minNodeForRight.getValue()));
            } else if (root.getLeft() != null){ // 왼쪽 자식만 있는 경우
                root = root.getLeft();
            } else if (root.getRight() != null){ // 오른쪽 자식만 있는 경우
                root = root.getRight();
            } else {
                root = null;
            }
        }
        return root;
    }

    /**
     * BST 삭제
     */
    public void deleteBST(){
        root = null;
        System.out.println("BST를 삭제했습니다.");
    }
}
