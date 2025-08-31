package algorithm.sort;

import algorithm.utils.print.MyPrint;

public class SortMain {
    public static void main(String[] args) {

        int[] arr = {5, 3, 4, 7, 2, 8, 6, 9, 1};
        MergeSort ms = new MergeSort();
        MyPrint.printArray(arr);
        ms.mergeSort(arr,0, arr.length-1);
        System.out.println("\nMerge Sort : ");
        MyPrint.printArray(arr);
    }
}
