package top.knin1.algo.heap;

import java.util.Comparator;

/**
 * 小顶堆
 * @author KNin1
 */
public class MinHeap<T> extends Heap<T> {

    public MinHeap(int capacity, Comparator<? super T> c) {
        super(capacity, c);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void heapifyDown(int pos) {
        while (true) {
            int minPos = pos;
            int childIndex = 2 * pos + 1;
            if (childIndex < count && comparator.compare((T) data[pos], (T) data[childIndex]) > 0) {
                minPos = childIndex;
            }
            childIndex += 1;
            if (childIndex < count && comparator.compare((T) data[minPos], (T) data[childIndex]) > 0) {
                minPos = childIndex;
            }
            if (minPos == pos) {
                break;
            }
            swap(pos, minPos);
            pos = minPos;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void heapifyUp() {
        int i = count - 1;
        int parentIndex;
        while ((comparator.compare((T) data[i], (T) data[(parentIndex = (i - 1) / 2)])) < 0) {
            swap(i, parentIndex);
            i = parentIndex;
        }
    }
}
