package de.luca.uebungsaufgaben.semester1.uebungsblatt07;

import de.luca.uebungsaufgaben.semester1.uebungsblatt03.Sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null) return null;
        return mergeSort(arrayToSort.clone());
    }

    private int[] mergeSort(int[] arrayToSort) {

        if (arrayToSort.length <= 1) return arrayToSort; // can't be sorted

        // split arrayToSort into 2 arrays
        int lengthA1 = arrayToSort.length >> 1; // same as arrayToSort.length / 2 but faster (and fancier :D)
        int lengthA2 = arrayToSort.length - lengthA1;

        int[] a1 = new int[lengthA1];
        int[] a2 = new int[lengthA2];

        System.arraycopy(arrayToSort, 0, a1, 0, a1.length);
        System.arraycopy(arrayToSort, lengthA1, a2, 0, a2.length);

        // sort both halves
        mergeSort(a1);
        mergeSort(a2);

        // merge both halves together (take smallest next value and put it at current index in arrayToSort)
        int indexArrayToSort = 0, indexA1 = 0, indexA2 = 0;

        while (indexA1 < a1.length && indexA2 < a2.length) {
            if (a1[indexA1] <= a2[indexA2]) {
                arrayToSort[indexArrayToSort] = a1[indexA1];
                indexArrayToSort++;
                indexA1++;
            } else {
                arrayToSort[indexArrayToSort] = a2[indexA2];
                indexArrayToSort++;
                indexA2++;
            }
        }
        // either a1 or a2 might still have some elements left
        while (indexA1 < a1.length) {
            arrayToSort[indexArrayToSort] = a1[indexA1];
            indexArrayToSort++;
            indexA1++;
        }
        while (indexA2 < a2.length) {
            arrayToSort[indexArrayToSort] = a2[indexA2];
            indexArrayToSort++;
            indexA2++;
        }

        return arrayToSort;
    }
}
