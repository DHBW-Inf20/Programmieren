package de.luca.uebungsaufgaben.uebungsblatt3;

public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort) {
        int[] result = arrayToSort.clone();

        boolean sortingComplete = false;
        int temp;

        while (!sortingComplete) {
            sortingComplete = true; //will be changed when if condition is true

            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] < result[i + 1]) {
                    temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;

                    sortingComplete = false;
                }
            }
        }

        return result;
    }
}
