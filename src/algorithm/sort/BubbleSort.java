package algorithm.sort;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n - i - 1; j++) {
                if (arr[j] < arr[j-1]) {
                    // swap elements
                    int temp = arr[j - 1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
