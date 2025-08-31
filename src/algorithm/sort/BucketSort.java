package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int arr[];

    public BucketSort(int arr[]) {
        this.arr = arr;
    }

    // 버킷 내용 확인하기
    public void printBuckets(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket #" + i + " : ");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public void bucketSort(){
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));   // 버킷의 개수
        int maxValue = Integer.MIN_VALUE;   // 배열의 최대값
        for(int value : arr){       // 배열의 최대값 찾기
            if(value > maxValue){   // 현재 값이 최대값보다 크면
                maxValue = value;   // 최대값 갱신
            }
        }
        
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];  // 버킷 배열 생성
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();  // 버킷 생성
        }

        for (int value : arr) {  // 배열의 값들을 버킷에 추가
            int bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets) / (float)maxValue);   // 버킷 번호
            buckets[bucketNumber - 1].add(value);   // 버킷에 값 추가
        }

        System.out.println("\nPrinting buckets before sorting : ");
        printBuckets(buckets);  // 버킷 내용 확인

        for (ArrayList<Integer> bucket : buckets) {  // 버킷 정렬
            Collections.sort(bucket);   // 버킷 정렬
        }
        System.out.println("\nPrinting buckets after sorting : ");
        printBuckets(buckets);  // 버킷 내용 확인

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {  // 정렬된 버킷을 배열에 추가
            for (int value : bucket) {  // 버킷의 값들을 배열에 추가
                arr[index++] = value;   // 배열에 값 추가
            }
        }
    }
}
