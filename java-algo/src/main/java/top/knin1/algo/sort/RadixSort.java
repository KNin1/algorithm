package top.knin1.algo.sort;

/**
 * 基数排序
 * @author KNin1
 * @date 2021-03-30
 */
public class RadixSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n < 2) {
            return;
        }
        int max = arr[0];
        for (int v : arr) {
            if (v > max) {
                max = v;
            }
        }
        int exp = 1;
        while (max / exp > 0) {
            countingSort(arr, exp);
            exp *= 10;
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int[] counts = new int[10];
        for (int v : arr) {
            counts[(v / exp) % 10]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }
        int[] tmp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = --counts[(arr[i] / exp) % 10];
            tmp[index] = arr[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }
}
