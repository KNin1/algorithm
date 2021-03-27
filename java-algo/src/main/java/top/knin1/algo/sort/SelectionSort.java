package top.knin1.algo.sort;

/**
 * @author KNin1
 */
public class SelectionSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            int minIndex = i;
            for (int j = i+1; j < n; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
