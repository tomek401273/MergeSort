package com.merge.sort.service;

import com.merge.sort.model.Person;

public class MergeSortPerson {

    public void sort(Person[] inputArray, ComparatorPerson comparatorPerson) {
        sort(inputArray, 0, inputArray.length - 1, comparatorPerson);
    }

    public void sort(Person[] inputArray, int start, int end, ComparatorPerson comparatorPerson) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(inputArray, start, mid, comparatorPerson);
            sort(inputArray, mid + 1, end, comparatorPerson);
            merge(inputArray, start, mid, end, comparatorPerson);
        }
    }

    public void merge(Person[] inputArray, int start, int mid, int end, ComparatorPerson comparatorPerson) {
        Person[] tempArray = new Person[end - start + 1];
        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;

        while (leftSlot <= mid && rightSlot <= end) {
            if (comparatorPerson.compare(inputArray[leftSlot], inputArray[rightSlot])){
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