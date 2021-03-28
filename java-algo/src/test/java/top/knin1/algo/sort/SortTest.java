package top.knin1.algo.sort;

import org.junit.Test;

/**
 * @author KNin1
 */
public class SortTest {
    @Test
    public void testBubbleSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        BubbleSort.sort(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testInsertSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        InsertSort.sort(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testSelectionSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        SelectionSort.sort(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        MergeSort.sort(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        QuickSort.sort(arr, arr.length);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
