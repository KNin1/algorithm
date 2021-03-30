package top.knin1.algo.sort;

import java.util.List;

/**
 * 桶排序
 * @author KNin1
 * @date 2021-03-30
 */
public class BucketSort {
    public static void sort(int[] arr, int n, int capacity) {
        if (arr == null || n < 2 || capacity < 1) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int v : arr) {
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }
        int bucketCounts = (max - min) / capacity + 1;
        int[][] buckets = new int[bucketCounts][capacity];
        int[] indexArr = new int[bucketCounts];

        for (int v : arr) {
            int bucketIdx = (v - min) / capacity;
            if (indexArr[bucketIdx] == buckets[bucketIdx].length) {
                ensureCapacity(buckets, bucketIdx);
            }
            buckets[bucketIdx][indexArr[bucketIdx]++] = v;
        }

        int k = 0;
        for (int i = 0; i < bucketCounts; ++i) {
            if (indexArr[i] == 0) {
                continue;
            }
            QuickSort.sort(buckets[i], indexArr[i]);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 数组扩容
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }
}
