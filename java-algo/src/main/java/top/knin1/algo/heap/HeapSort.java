package top.knin1.algo.heap;

import java.util.Comparator;

/**
 * 堆排序
 * @author KNin1
 * @date 2021-04-13
 */
public class HeapSort<T> {
    private final Comparator<? super T> comparator;

    public HeapSort(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] data) {
        int n = data.length - 1;
        buildHeap(data, n);
        // 将堆顶元素与数组最后一个元素交换，然后对前 n - 1 个元素进行自上而下的堆化
        int k = n;
        while ( k > 0) {
            swap(data, 0, k);
            --k;
            heapify(data, k, 0);
        }
    }

    /**
     * 建堆过程
     * 从最后一个非叶子节点到根节点，依次执行自上而下的堆化
     */
    private void buildHeap(T[] data, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }
    }

    /**
     * 自上而下堆化
     */
    private void heapify(T[] data, int n, int i) {
        while (true) {
            int minPos = i;
            int childIndex = 2 * i + 1;
            if (childIndex <= n && comparator.compare(data[i], data[childIndex]) < 0) {
                minPos = childIndex;
            }
            childIndex += 1;
            if (childIndex <= n && comparator.compare(data[minPos], data[childIndex]) < 0) {
                minPos = childIndex;
            }
            if (minPos == i) {
                break;
            }
            swap(data, i, minPos);
            i = minPos;
        }
    }

    private void swap(T[] data, int index1, int index2) {
        T tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }
}
