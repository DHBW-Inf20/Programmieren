package semester1.uebungsblatt07;

import semester1.uebungsblatt03.Sorter;
import semester1.uebungsblatt03.BubbleSort;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rd = new Random();

        int[] unsorted = new int[100_000];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = rd.nextInt(1_000_000);
        }

        Sorter sorter = new BubbleSort();
        System.out.println("-----------------------\nBubbleSort:");
        sortTest(unsorted, sorter);

        sorter = new MergeSort();
        System.out.println("-----------------------\nMergeSort:");
        sortTest(unsorted, sorter);

        System.out.println("-----------------------\nMergeSortInPlace:");
        sorter = new MergeSortInPlace();
        sortTest(unsorted, sorter);

        System.out.println("-----------------------\nQuickSort:");
        sorter = new QuickSort();
        sortTest(unsorted, sorter);

        System.out.println("-----------------------\nHeapSort:");
        sorter = new HeapSort();
        sortTest(unsorted, sorter);
    }

    private static void sortTest(int[] array, Sorter sorter) {
        DecimalFormat format = new DecimalFormat();

        int[] unsorted = array.clone();
        int[] sorted;

        System.out.println("elements: " + format.format(array.length));

        long time = System.nanoTime();
        sorted = sorter.sort(unsorted);
        time = System.nanoTime() - time;

        System.out.println("time: " + format.format(time) + " ns");

        Arrays.sort(unsorted);
        boolean isSorted = Arrays.equals(unsorted, sorted);
        if (isSorted) System.out.println("isSorted: " + true);
        else System.err.println("isSorted: " + false);
    }
}
