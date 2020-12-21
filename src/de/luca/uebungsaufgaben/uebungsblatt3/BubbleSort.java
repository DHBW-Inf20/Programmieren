package de.luca.uebungsaufgaben.uebungsblatt3;

public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null) return null;
        int[] result = arrayToSort.clone();

        boolean sortingComplete = false;
        int temp;
        int limit = result.length - 1;

        while (!sortingComplete) {
            sortingComplete = true; // will be changed if condition is true

            for (int i = 0; i < limit; i++) {
                if (result[i] > result[i + 1]) {
                    temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;

                    sortingComplete = false;
                }
            }

            limit--; // number of sorted elements increases after each iteration => limit can be decremented
        }

        return result;
    }
}
