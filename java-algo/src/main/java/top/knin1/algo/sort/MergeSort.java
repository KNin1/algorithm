package top.knin1.algo.sort;

/**
 * 归并排序
 * @author KNin1
 * 2021-03-28
 */
public class MergeSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        mergeSort(arr, 0, n-1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }
        int left = i;
        int right = mid;
        if (j <= end) {
            left = j;
            right = end;
        }
        while (left <= right) {
            tmp[k++] = arr[left++];
        }
        for (k = 0; k < tmp.length; ++k) {
            arr[start+k] = tmp[k];
        }
    }
}
