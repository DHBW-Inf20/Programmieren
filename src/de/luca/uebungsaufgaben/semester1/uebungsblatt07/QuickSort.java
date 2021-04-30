package de.luca.uebungsaufgaben.semester1.uebungsblatt07;

import de.luca.uebungsaufgaben.semester1.uebungsblatt03.Sorter;

public class QuickSort implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null) return null;
        return quickSort(arrayToSort.clone(), 0, arrayToSort.length - 1);
    }

    private int[] quickSort(int[] arrayToSort, int start, int end) {

        int length = end + 1 - start;
        if (length <= 1) return arrayToSort; // can't be sorted

        //       first value              middle value                          last value
        int v1 = arrayToSort[start], v2 = arrayToSort[(start + end) >> 1], v3 = arrayToSort[end];

        // median of first value, middle value and last value
        int pivot = v1 >= v2
                ? (v1 >= v3 ? Math.max(v2, v3) : v1)
                : (v1 >= v3 ? v1 : Math.min(v2, v3));

        int iteratorFromStart = start, iteratorFromEnd = end;

        while (iteratorFromStart <= iteratorFromEnd) {

            while (arrayToSort[iteratorFromStart] < pivot) iteratorFromStart++; // skip all that are smaller than pivot
            while (pivot < arrayToSort[iteratorFromEnd]) iteratorFromEnd--;     // skip all that are bigger than pivot

            if (iteratorFromStart <= iteratorFromEnd) { // array not yet split into two sub-arrays

                if (iteratorFromStart != iteratorFromEnd) { // swap otherwise unnecessary

                    // swap first element that is >= pivot and last element that is <= pivot
                    int temp = arrayToSort[iteratorFromStart];
                    arrayToSort[iteratorFromStart] = arrayToSort[iteratorFromEnd];
                    arrayToSort[iteratorFromEnd] = temp;
                }
                // increment/decrement even if no swap occurred (in that case arrayToSort[iterator] == pivot)
                iteratorFromStart++;
                iteratorFromEnd--;
            }
        }

        if (start < iteratorFromEnd) quickSort(arrayToSort, start, iteratorFromEnd); // sort all smaller than pivot
        if (iteratorFromStart < end) quickSort(arrayToSort, iteratorFromStart, end); // sort all bigger than pivot

        return arrayToSort;
    }
}
