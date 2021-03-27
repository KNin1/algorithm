package top.knin1.algo.sort;

/**
 * @author KNin1
 */
public class InsertSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = value;
        }
    }
}
