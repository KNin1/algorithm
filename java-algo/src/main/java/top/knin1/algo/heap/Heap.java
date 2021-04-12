package top.knin1.algo.heap;

import java.util.Comparator;

/**
 * 大顶堆
 * @author KNin1
 * @date 2021-04-12
 */
public class Heap<T> {
    private final Comparator<? super T> comparator;
    private Object[] data;
    private int capacity; // 堆可以存储的最大数据量
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity, Comparator<? super T> c) {
        this.capacity = capacity;
        this.comparator = c;
        count = 0;
        data = new Object[capacity];
    }

    public void insert(T value) {
        if (count >= capacity) {
            return;
        }
        data[count] = value;
        int i = count;
        int parentIndex;
        // 自下向上堆化
        while ((comparator.compare((T) data[i], (T) data[(parentIndex = (i - 1) / 2)])) > 0) {
            swap(i, parentIndex);
            i = parentIndex;
        }
        ++count;
    }

    /**
     * 交换堆顶元素和数组中最后一个元素，然后自上而下堆化
     */
    public void removeTop() {
        if (count == 0) {
            return;
        }
        data[0] = data[--count];
        heapify(0);
    }

    /**
     * 自上而下堆化
     */
    private void heapify(int i) {
        while (true) {
            int minPos = i;
            int childIndex = 2 * i + 1;
            if (childIndex < count && comparator.compare((T) data[i], (T) data[childIndex]) < 0) {
                minPos = childIndex;
            }
            childIndex += 1;
            if (childIndex < count && comparator.compare((T) data[minPos], (T) data[childIndex]) < 0) {
                minPos = childIndex;
            }
            if (minPos == i) {
                break;
            }
            swap(i, minPos);
            i = minPos;
        }
    }

    private void swap(int index1, int index2) {
        Object tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    protected void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }
}
