package top.knin1.algo.heap;

import java.util.Comparator;
import java.util.Objects;

/**
 * 使用堆计算 TopK 问题
 * @author KNin1
 * @date 2021-04-14
 */
public class TopK {
    public static <T> Object[] solution(T[] data, Comparator<? super T> c, int k) {
        MinHeap<T> heap = new MinHeap<>(k, c);
        for (T item : data) {
            if (!heap.isFull()) {
                heap.insert(item);
            } else {
                // 堆满后，比较堆顶元素与数组元素的大小
                // 当数组元素大于堆顶元素时，删除堆顶元素，然后将数组元素插入堆中
                if (Objects.compare(item, heap.top(), c) > 0) {
                    heap.removeTop();
                    heap.insert(item);
                }
            }
        }
        return heap.getData();
    }
}
