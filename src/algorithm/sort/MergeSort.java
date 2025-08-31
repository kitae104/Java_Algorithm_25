package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public void merge1(int[] arr, int left, int middle, int right){
        int[] leftArr = new int[middle - left + 2]; // +2 for sentinel value
        int[] rightArr = new int[right - middle + 1]; // +1 for sentinel value

        for (int i = 0; i <= middle-left ; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < right - middle; i++) {
            rightArr[i] = arr[middle + 1 + i];
        }

        leftArr[middle-left+1] = Integer.MAX_VALUE;
        rightArr[right-middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
        }
        System.out.print("Left Array : ");
        Arrays.stream(leftArr).forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.print("Right Array : ");
        Arrays.stream(rightArr).forEach(n -> System.out.print(n + " "));
        System.out.println();

    }

    public void merge(int[] intArray, int low, int mid, int high)
    {
        int[] temp = new int[high + 1];		// 합병된 결과를 저장하기 위한 임시 배열
        int h = low;						// 임시 배열의 인덱스
        int i = low;						// 왼쪽 배열의 인덱스
        int j = mid + 1;					// 오른쪽 배열의 인덱스

        // 왼쪽 반의 요소와 오른쪽 반의 요소를 순서대로 비교하여 작은 값을 임시 배열로 옮긴다
        while(i <= mid && j<=high)
        {
            if(intArray[i] <= intArray[j])
            {
                temp[h] = intArray[i];			// 오른쪽이 큰 경우 왼쪽 값을 임시 배열에 옮김
                i = i + 1;						// i 값을 증가 시킴
            }
            else
            {
                temp[h] = intArray[j];			// 왼쪽이 큰 경우 오른쪽 값을 임시 배열에 옮김
                j = j + 1;						// j 값을 증가 시킴
            }
            h = h + 1;							// 임시 배열의 인덱스 증가
        }

        if(i > mid)
        {	// 오른쪽에 남아있는 요소를 임시 배열에 옮긴다.
            for(int k = j; k <= high; k++)
            {
                temp[h] = intArray[k];
                h = h + 1;
            }
        }
        else
        {	// 왼쪽에 남아있는 요소를 임시 배열에 옮긴다.
            for(int k = i; k <= mid; k++)
            {
                temp[h] = intArray[k];
                h = h + 1;
            }
        }

        for (int l = low; l <= high; l++)
        {	// 임시 배열 B[low..high]를 배열 A[low..high]로 옮긴다
            intArray[l] = temp[l];
        }
    }

    public void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }
}
