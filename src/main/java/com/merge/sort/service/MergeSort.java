package com.merge.sort.service;

public class MergeSort {

    public void sort(Integer[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    public void sort(Integer[] inputArray, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(inputArray, start, mid);
            sort(inputArray, mid + 1, end);
            merge(inputArray, start, mid, end);
        }
    }

    public void merge(Integer[] inputArray, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
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
}