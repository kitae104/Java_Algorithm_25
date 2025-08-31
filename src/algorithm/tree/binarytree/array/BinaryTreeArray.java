package algorithm.tree.binarytree.array;

import lombok.Data;

@Data
public class BinaryTreeArray {
    private String[] arr; // 배열
    int lastUsedIndex;  // 마지막으로 사용된 인덱스

    public BinaryTreeArray(int size) {
        arr = new String[size + 1]; // 0번 인덱스는 사용하지 않기 위해 size + 1
        this.lastUsedIndex = 0;
        System.out.printf("크기가 %d 인 Binary tree 를 생성했습니다.\n", size);
    }

    /**
     * 가득 찼는지 확인<br />
     * 배열의 길이에서 1을 뺀 값과 마지막으로 사용된 인덱스 값이 같으면 가득 찬 것으로 판단
     */
    public boolean isFull() {
        return lastUsedIndex == arr.length - 1;
    }

    /**
     * 노드 삽입<br />
     * 가득 찼는지 확인 후 마지막으로 사용된 인덱스에 1을 더한 인덱스에 값을 삽입
     */
    public void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println(value + " 를 성공적으로 삽입했습니다.");
        } else {
            System.out.println("Binary tree 가 가득 찼습니다.");
        }
    }

    /**
     * 전위 순회<br />
     * 노드 -> 왼쪽 자식 노드 -> 오른쪽 자식 노드
     */
    public void preOrder(int index){
        if(index > lastUsedIndex){  // index 가 마지막으로 사용된 인덱스보다 크면 종료
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);  // 왼쪽 자식 노드
        preOrder(index * 2 + 1);  // 오른쪽 자식 노드
    }

    /**
     * 중위 순회<br />
     * 왼쪽 자식 노드 -> 노드 -> 오른쪽 자식 노드
     */
    public void inOrder(int index) {
        if(index > lastUsedIndex){  // index 가 마지막으로 사용된 인덱스보다 크면 종료
            return;
        }
        inOrder(index * 2);  // 왼쪽 자식 노드
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);  // 오른쪽 자식 노드
    }

    /**
     * 후위 순회<br />
     * 왼쪽 자식 노드 -> 오른쪽 자식 노드 -> 노드
     */
    public void postOrder(int index) {
        if (index > lastUsedIndex) {  // index 가 마지막으로 사용된 인덱스보다 크면 종료
            return;
        }
        postOrder(index * 2);  // 왼쪽 자식 노드
        postOrder(index * 2 + 1);  // 오른쪽 자식 노드
        System.out.print(arr[index] + " ");
    }

    /**
     * 레벨 순회
     */
    public void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 노드 검색
     * @param value 검색할 값
     * @return 검색한 값의 인덱스
     */
    public int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i].equals(value)) {
                System.out.println(value + " 를 찾았고, 위치는 " + i + "에 있습니다.");
                return i;
            }
        }
        System.out.println(value + " 를 찾지 못했습니다.");
        return -1;
    }

    /**
     * 노드 삭제
     * @param value 삭제할 값
     */
    public void delete(String value){
        int index = search(value);  // 삭제할 값의 인덱스
        if(index == -1){    // 삭제할 값이 없으면 종료
            return;
        }
        arr[index] = arr[lastUsedIndex];    // 삭제할 값에 마지막으로 사용된 인덱스의 값을 넣어줌
        lastUsedIndex--;    // 마지막으로 사용된 인덱스를 1 감소
        System.out.println(value + " 를 성공적으로 삭제했습니다.");
    }

    /**
     * Binary tree 삭제
     */
    public void deleteBinaryTree() {
        try {
            arr = null;
            System.out.println("Binary tree 를 삭제했습니다.");
        } catch (Exception e) {
            System.out.println("Binary tree 가 이미 삭제되었습니다.");
        }
    }
}
