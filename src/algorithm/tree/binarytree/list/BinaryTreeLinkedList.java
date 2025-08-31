package algorithm.tree.binarytree.list;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class BinaryTreeLinkedList {
    private BinaryNode root;    // 루트 노드

    /**
     * 기본 생성자
     */
    public BinaryTreeLinkedList() {
        this.root = null;
    }

    /**
     * 전위 순회
     *
     * @param node
     */
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 중위 순회
     *
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
     *
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
     */
    public void levelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {                      // 큐가 비어있지 않을 때까지 반복
            BinaryNode node = queue.remove();           // 큐에서 하나의 노드를 꺼냄
            System.out.print(node.getValue() + " ");    // 꺼낸 노드의 값을 출력
            if (node.getLeft() != null) {               // 왼쪽 자식 노드가 있으면 큐에 추가
                queue.add(node.getLeft());              // 왼쪽 자식 노드를 큐에 추가
            }
            if (node.getRight() != null) {              // 오른쪽 자식 노드가 있으면 큐에 추가
                queue.add(node.getRight());             // 오른쪽 자식 노드를 큐에 추가
            }
        }
    }

    /**
     * 이진 트리 검색<br/>
     * - 레벨 순회를 이용함 : 큐를 이용하여 레벨 순회를 수행하면서 값을 찾음<br/>
     * - 일반적으로 스택보다는 큐를 이용하는 것이 효과적임<br/>
     * @param value
     */
    public void search(BinaryNode root, String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if (node.getValue().equals(value)) {
                System.out.println("해당 값 " + value + "을 찾았습니다.");
                return;
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        System.out.println("해당 값 " + value + "을 찾지 못했습니다.");
    }

    /**
     * 이진 트리에 새로운 노드 삽입<br/>
     * - 레벨 순회를 이용함 : 큐를 이용하여 레벨 순회를 수행하면서 값을 추가할 위치를 찾음<br/>     *
     * @param value
     */
    public void insertNode(String value) {
        BinaryNode newNode = new BinaryNode(value);
        if(root == null) {
            root = newNode;
            System.out.println("루트에 노드" + newNode.getValue() + " 추가");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove(); // 큐에서 하나의 노드를 꺼냄
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                System.out.println(node.getValue() + "의 왼쪽에 노드 " + newNode.getValue() + "추가");
                return;
            } else {
                queue.add(node.getLeft());  // 왼쪽 자식 노드가 있으면 큐에 추가
            }
            if (node.getRight() == null) {
                node.setRight(newNode);
                System.out.println(node.getValue() + "의 오른쪽에 노드" + newNode.getValue() + " 추가");
                return;
            } else {
                queue.add(node.getRight()); // 오른쪽 자식 노드가 있으면 큐에 추가
            }
        }
    }

    /**
     * 이진 트리에서 노드 삭제<br/>
     * - 레벨 순회를 이용함 : 큐를 이용하여 레벨 순회를 수행하면서 값을 찾아 삭제<br/>
     * @param value
     */
    public void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode node = queue.remove();   // 큐에서 하나의 노드를 꺼냄
            if(node.getValue().equals(value)) { // 삭제할 노드를 찾으면
                BinaryNode deepestNode = getDeepestNode(); // 가장 깊은 노드를 가져옴
                node.setValue(deepestNode.getValue()); // 삭제할 노드의 값을 가장 깊은 노드의 값으로 변경
                deleteDeepestNode(); // 가장 깊은 노드 삭제
                System.out.println("노드 " + value + " 삭제");
                return;
            } else {
                if(node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
        System.out.println("노드 " + value + "를 찾지 못했습니다.");
    }

    /**
     * 이진 트리에서 가장 깊은 곳에 있는 노드 가져오기(마지막 노드) <br />
     */
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();   // 큐 생성
        queue.add(root);                            // 루트 노드를 큐에 추가
        BinaryNode node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();  // 큐에서 하나의 노드를 꺼냄
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return node;
    }

    /**
     * 이진 트리에서 가장 깊은 곳에 있는 노드 삭제하기(마지막 노드) <br />
     */
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();   // 큐 생성
        queue.add(root);                            // 루트 노드를 큐에 추가
        BinaryNode previousNode, node = null;
        while (!queue.isEmpty()) {
            previousNode = node;    // 이전 노드를 현재 노드로 변경
            node = queue.remove();  // 큐에서 하나의 노드를 꺼냄
            if (node.getLeft() == null) {   // 왼쪽 자식 노드가 없으면
                previousNode.setRight(null);   // 이전 노드의 오른쪽 노드를 null로 변경
                return;
            }
            if (node.getRight() == null) { // 오른쪽 자식 노드가 없으면
                node.setLeft(null); // 현재 노드의 왼쪽 노드를 null로 변경
                return;
            }
            queue.add(node.getLeft());
            queue.add(node.getRight());
        }
    }

    /**
     * 이진 트리 삭제
     */
    public void deleteTree() {
        root = null;
        System.out.println("트리 삭제 완료");
    }
}
