package top.knin1.algo.sort;

/**
 * @author KNin1
 * @date 2021-03-28
 */
public class QuickSort {
    public static void sort(int[] arr, int n) {
        if (arr == null || n <= 1) {
            return;
        }
        quickSort(arr, 0, n-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    /**
     * 分区函数
     * 将待排序区间分成三个区域：小于 pivot 区域、pivot、大于 pivot 区域
     */
    private static int partition(int[] arr, int start, int end) {
        /*
         通过游标 i 将 arr[start, end-1]分成两部分，arr[p...i-1]中元素都小于 pivot，称为已处理区间，
         arr[i...end-1]是未处理区间，每次从未处理区间中取出一个元素 arr[j] 与 pivot 比较，如果小于 pivot，
         则将其加入到已处理区间的尾部，即 arr[i]
         */
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
