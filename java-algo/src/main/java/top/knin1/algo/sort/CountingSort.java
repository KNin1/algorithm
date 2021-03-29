package top.knin1.algo.sort;

/**
 * 计数排序
 * @author KNin1
 * @date 2021-03-29
 */
public class CountingSort {
    /**
     * 数组中存储非负整数
     * @param arr
     * @param n
     */
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < n; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 计数数组
        int[] c = new int[max + 1];
        for (int i : arr) {
            c[i]++;
        }
        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i-1];
        }

        int[] r = new int[n];
        // 从后向前保证排序稳定
        for (int i = n - 1; i >= 0; --i) {
            int index = c[arr[i]] - 1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = r[i];
        }
    }
}
