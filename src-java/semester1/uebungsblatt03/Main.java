package semester1.uebungsblatt03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sorter sorter = new BubbleSort();

        int[] unsorted = {84, 69, 76, 86, 94, 91};
        int[] sorted = sorter.sort(unsorted);

        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
