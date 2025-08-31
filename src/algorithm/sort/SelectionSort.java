package algorithm.sort;

import algorithm.utils.print.MyPrint;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        MyPrint.printArray(arr);
        selectionSort(arr);
        MyPrint.printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minimumIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int temp = arr[minimumIndex];
            arr[minimumIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
