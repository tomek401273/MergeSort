package com.merge.sort.service;
import java.util.Arrays;

public class MergeSort {

    public void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    public void sort(int inputArray[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(inputArray, start, mid);
            sort(inputArray, mid + 1, end);
            merge(inputArray, start, mid, end);
        }
    }

    public void merge(int inputArray[], int start, int mid, int end) {
        int tempArray[] = new int[end - start + 1];
        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;

        while (leftSlot <= mid && rightSlot <= end) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
            } else {
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
            }
            k++;
        }

        while (leftSlot <= mid) {
            tempArray[k] = inputArray[leftSlot];
            leftSlot++;
            k++;
        }
        while (rightSlot <= end) {
            tempArray[k] = inputArray[rightSlot];
            rightSlot++;
            k++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            inputArray[i + start] = tempArray[i];
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{9, 7, 3, 1, 6, 3, 2, 6, 11, 9, 2, 3, 0, 22, 100};
//        int[] A = new int[]{9, 7, 10, 11};
        MergeSort mergeSort= new MergeSort();
        mergeSort.sort(A);
        Arrays.stream(A).mapToObj(Integer::new).map(x -> x + ", ").forEach(System.out::print);
    }
}