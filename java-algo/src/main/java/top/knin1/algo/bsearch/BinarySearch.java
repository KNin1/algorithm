package top.knin1.algo.bsearch;

/**
 * 简单二分查找
 * @author KNin1
 * @date 2021-04-02
 */
public class BinarySearch {
    public static int search(int[] arr, int value) {
        if (isEmptyArray(arr)) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static boolean isEmptyArray(int[] arr) {
        return arr == null || arr.length == 0;
    }
}
