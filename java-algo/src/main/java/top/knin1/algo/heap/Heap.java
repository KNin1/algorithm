package top.knin1.algo.heap;

import java.util.Comparator;

/**
 * 大顶堆
 * @author KNin1
 * @date 2021-04-12
 */
public abstract class Heap<T> {
    protected final Comparator<? super T> comparator;
    protected Object[] data;
    protected int capacity; // 堆可以存储的最大数据量
    protected int count; // 堆中已经存储的数据个数

    public Heap(int capacity, Comparator<? super T> c) {
        this.capacity = capacity;
        this.comparator = c;
        count = 0;
        data = new Object[capacity];
    }

    public void insert(T value) {
        if (isFull()) {
            return;
        }
        data[count++] = value;
        heapifyUp();
    }

    /**
     * 自上而下堆化
     * @param pos: 起始位置
     */
    protected abstract void heapifyDown(int pos);

    /**
     * 自下而上堆化
     */
    protected abstract void heapifyUp();

    /**
     * 交换堆顶元素和数组中最后一个元素，然后自上而下堆化
     */
    public void removeTop() {
        if (count == 0) {
            return;
        }
        data[0] = data[--count];
        heapifyDown(0);
    }

    public boolean isFull() {
        return count >= capacity;
    }

    protected void swap(int index1, int index2) {
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
