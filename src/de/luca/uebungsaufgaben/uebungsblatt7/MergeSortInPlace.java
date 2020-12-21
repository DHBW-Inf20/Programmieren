package de.luca.uebungsaufgaben.uebungsblatt7;

import de.luca.uebungsaufgaben.uebungsblatt3.Sorter;

public class MergeSortInPlace implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null) return null;
        return mergeSortInPlace(arrayToSort.clone(), 0, arrayToSort.length);
    }

    private int[] mergeSortInPlace(int[] arrayToSort, int start, int end) {

        int length = end - start;
        if (length <= 1) return arrayToSort; // can't be sorted

        // split arrayToSort into 2 sub-arrays (by finding mid index)
        int mid = (length >> 1) + start; // same as (length / 2) + start but faster (and fancier :D)

        // sort both sub-arrays
        mergeSortInPlace(arrayToSort, start, mid);
        mergeSortInPlace(arrayToSort, mid, end);

        // merge both sub-arrays together (take smallest next value and put it at current index in arrayToSort)
        int indexArrayToSort = start, indexSubA1 = start, limitSubA1 = mid, indexSubA2 = mid;

        while (indexSubA1 < limitSubA1 && indexSubA2 < end) {
            if (arrayToSort[indexSubA1] <= arrayToSort[indexSubA2]) { // smallest value already at correct position
                indexArrayToSort++;
                indexSubA1++;
            } else {
                // put value at indexSubA2 at indexArrayToSort and shift all elements between both 1 index back
                shift(arrayToSort, indexArrayToSort, indexSubA2);
                indexArrayToSort++;
                indexSubA2++;

                // sub-array 1 has been shifted 1 index back => increment index and limit
                indexSubA1++;
                limitSubA1++;
            }
        }

        return arrayToSort;
    }

    private void shift(int[] array, int to, int from) {
        int temp = array[from];
        System.arraycopy(array, to, array, to + 1, from - to);
        array[to] = temp;
    }
}
