package semester1.uebungsblatt07;

import semester1.uebungsblatt03.Sorter;

public class HeapSort implements Sorter {

    /*
     * tree structure of array:
     *
     * int[] tree = {15, 10, 13, 8, 3, 1, 9, 5, 0, 12, 7};
     * tree:          15
     *            /        \
     *         10             13
     *      /      \         /  \
     *    8          3      1    9
     *   / \        / \
     *  5   0     12   7
     * (all stages before last are completely filled)
     */

    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort == null) return null;
        return heapSort(arrayToSort.clone());
    }

    private int[] heapSort(int[] arrayToSort) {

        buildMaxHeap(arrayToSort);

        for (int i = arrayToSort.length - 1; i > 0; i--) {
            swapIn(arrayToSort, 0, i);
            maxHeapify(arrayToSort, 0, i);
        }

        return arrayToSort;
    }

    private void buildMaxHeap(int[] tree) {
        /*
         * int[] tree = {15, 10, 13, 8, 3, 1, 9, 5, 0, 12, 7};
         * tree:          15
         *            /        \
         *         10             13
         *      /      \         /  \
         *    8          3      1    9
         *   / \        / \
         *  5   0     12   7
         *
         * buildMaxHeap(tree);
         *
         * int[] tree: {15, 12, 13, 8, 10, 1, 9, 5, 0, 3, 7};
         * tree:           15
         *            /          \
         *         12               13
         *      /      \           /  \
         *    8          10       1    9
         *   / \        /  \
         *  5   0      3    7
         */

        int lastIndexWithChildren = (tree.length / 2) - 1;
        for (int i = lastIndexWithChildren; i >= 0; i--) {
            maxHeapify(tree, i, tree.length);
        }
    }

    private void maxHeapify(int[] tree, int indexCurrentNode, int treeSize) {

        /*
         * int[] tree = {15, 10, 13, 8, 3, 1, 9, 5, 0, 12, 7};
         * tree:          15
         *            /        \
         *         10             13
         *      /      \         /  \
         *    8          3      1    9
         *   / \        / \
         *  5   0     12   7
         *
         * maxHeapify(tree, 4, tree.length);
         *
         * int[] tree: {15, 10, 13, 8, 12, 1, 9, 5, 0, 3, 7};
         * tree:           15
         *            /          \
         *         10               13
         *      /      \           /  \
         *    8          12       1    9
         *   / \        /  \
         *  5   0      3    7
         */

        // + 1 and - 1 because calculation indexLeftChild = indexCurrentNode * 2 only works if index would start with 1
        int indexLeftChild = ((indexCurrentNode + 1) * 2) - 1;
        int indexRightChild = indexLeftChild + 1;

        if (indexLeftChild < treeSize && indexRightChild >= treeSize) { // left child is last node in tree
            // => swap if left child is bigger
            if (tree[indexLeftChild] > tree[indexCurrentNode]) swapIn(tree, indexCurrentNode, indexLeftChild);

        } else if (indexRightChild < treeSize) { // left child and right child exist
            int indexBiggerChild = tree[indexLeftChild] > tree[indexRightChild] ? indexLeftChild : indexRightChild;

            if (tree[indexBiggerChild] > tree[indexCurrentNode]) { // bigger child is bigger than current node
                // => swap and maxHeapify sub-heap
                swapIn(tree, indexCurrentNode, indexBiggerChild);
                maxHeapify(tree, indexBiggerChild, treeSize);
            }
        }
    }

    private void swapIn(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
