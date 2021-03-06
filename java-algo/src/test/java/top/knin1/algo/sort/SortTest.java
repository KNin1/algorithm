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

    @Test
    public void testDualPivotQuickSort() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        DualPivotQuickSort.sort(arr);
        printArray(arr);
    }

    @Test
    public void testCountingSort() {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        CountingSort.sort(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testBucketSort() {
        int[] arr = {4, 5, 0, 9, 3, 3, 1, 9, 8, 7};
        BucketSort.sort(arr, arr.length, 3);
        printArray(arr);
    }

    @Test
    public void testRadixSort() {
        int[] arr = {92971917, 92977626, 92971912};
        RadixSort.sort(arr, arr.length);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
