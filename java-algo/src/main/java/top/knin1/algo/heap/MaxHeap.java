package top.knin1.algo.heap;

import java.util.Comparator;

/**
 * 大顶堆
 * @author KNin1
 */
public class MaxHeap<T> extends Heap<T> {
    public MaxHeap(int capacity, Comparator<? super T> c) {
        super(capacity, c);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void heapifyDown(int pos) {
        while (true) {
            int maxPos = pos;
            int childIndex = 2 * pos + 1;
            if (childIndex < count && comparator.compare((T) data[pos], (T) data[childIndex]) < 0) {
                maxPos = childIndex;
            }
            childIndex += 1;
            if (childIndex < count && comparator.compare((T) data[maxPos], (T) data[childIndex]) < 0) {
                maxPos = childIndex;
            }
            if (maxPos == pos) {
                break;
            }
            swap(pos, maxPos);
            pos = maxPos;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void heapifyUp() {
        int i = count - 1;
        int parentIndex;
        while ((comparator.compare((T) data[i], (T) data[(parentIndex = (i - 1) / 2)])) > 0) {
            swap(i, parentIndex);
            i = parentIndex;
        }
    }
}
