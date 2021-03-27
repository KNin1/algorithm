package top.knin1.algo.sort;

/**
 * @author KNin1
 */
public class BubbleSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean swapFlag = false;
            for (int j = 0; j < n - i - 1;++j) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }
}
