package com.merge.sort.service;

import com.merge.sort.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MergeSortPerson {

    public void sort(List<Person> inputArray, ComparatorPerson comparatorPerson) {
        sort(inputArray, 0, inputArray.size() - 1, comparatorPerson);
    }

    public void sort(List<Person> inputArray, int start, int end, ComparatorPerson comparatorPerson) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(inputArray, start, mid, comparatorPerson);
            sort(inputArray, mid + 1, end, comparatorPerson);
            merge(inputArray, start, mid, end, comparatorPerson);
        }
    }
// to jest prawie to samo co ostanio są 2 główne rożnice
    // 1) działa to na List<Person> zamiast na array Integerów lub array int już nie pamiętam co było
    public void merge(List<Person> inputArray, int start, int mid, int end, ComparatorPerson comparatorPerson) {
        List<Person> tempArray = new ArrayList<>(end - start + 1);
        int leftSlot = start;
        int rightSlot = mid + 1;
        int k = 0;
        while (leftSlot <= mid && rightSlot <= end) {
            // tuaj zamiast porównywać integery prównujemy persons ich wartości
            // wywołujemy to na comparatorPerson
            // wtedy było to jakoś tak inputArray[leftslot]<inputArray[rightSlot]
            // teraz wywołujemy comparatorPerson.compare
            // i przekazujemy jej odpowiedznie obiekty typu Person
            // inputArray.get(leftSlot) wtedyt obył integer (lub int) z array teraz to jest objekt typu Person z List
            // i tak analogicznie z drugim argumentem
            if (comparatorPerson.compare(inputArray.get(leftSlot), inputArray.get(rightSlot))) {
                tempArray.add(k, inputArray.get(leftSlot));
                leftSlot++;
            } else {
                tempArray.add(k, inputArray.get(rightSlot));
                rightSlot++;
            }
            k++;
        }

        while (leftSlot <= mid) {
            tempArray.add(k, inputArray.get(leftSlot));
            leftSlot++;
            k++;
        }
        while (rightSlot <= end) {
            tempArray.add(k, inputArray.get(rightSlot));
            rightSlot++;
            k++;
        }

        for (int i = 0; i < tempArray.size(); i++) {
            inputArray.set(i + start, tempArray.get(i));
        }

    }
}