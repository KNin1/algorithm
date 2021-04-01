package top.knin1.algo.sort;

/**
 * 双轴快排
 * @author KNin1
 * @date 2021-04-01
 */
public class DualPivotQuickSort {
    public static void sort(int[] arr) {
        dualPivotQuickSort(arr, 0, arr.length - 1);
    }

    private static void dualPivotQuickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (arr[start] > arr[end]) {
            swap(arr, start, end);
        }
        int pivot1 = arr[start];
        int pivot2 = arr[end];
        int less = start;
        int great = end;
        while (arr[++less] < pivot1);
        while (arr[--great] > pivot2);
        /*
         * Partitioning:
         *
         *   left part           center part                   right part
         * +--------------------------------------------------------------+
         * |  < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2  |
         * +--------------------------------------------------------------+
         *               ^                          ^       ^
         *               |                          |       |
         *              less                        k     great
         *
         * Invariants:
         *
         *              all in (left, less)   < pivot1
         *    pivot1 <= all in [less, k)     <= pivot2
         *              all in (great, right) > pivot2
         *
         * Pointer k is the first index of ?-part.
         */
        for (int k = less; k <= great; k++) {
            int ak = arr[k];
            if (ak < pivot1) {
                swap(arr, k, less);
                less++;
            } else if (ak > pivot2) {
                boolean partitionEnd = false;
                while (arr[great] > pivot2) {
                    if (--great == k) {
                        partitionEnd = true;
                        break;  // end while
                    }
                }
                if (partitionEnd) {
                    break;  // end for
                }
                if (arr[great] < pivot1) {
                    arr[k] = arr[less];
                    arr[less] = arr[great];
                    ++less;
                } else { // pivot1 <= a[great] <= pivot2
                    arr[k] = arr[great];
                }
                arr[great] = ak;
                great--;
            } // else pivot1 <= ak <= pivot2
        }

        dualPivotQuickSort(arr, start, less - 1);
        dualPivotQuickSort(arr, less + 1, great - 1);
        dualPivotQuickSort(arr, great + 1, end);
    }

    private static void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
