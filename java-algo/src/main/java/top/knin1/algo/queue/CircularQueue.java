package top.knin1.algo.queue;

/**
 * 循环队列
 * @author KNin1
 */
public class CircularQueue<T> extends ArrayQueue<T> {
    public CircularQueue() {
        super();
    }

    public CircularQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean enqueue(T data) {
        if (isFullQueue()) {
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (isEmptyQueue()) {
            return null;
        }
        T value = (T) items[head];
        head = (head + 1) % capacity;
        return value;
    }

    private boolean isFullQueue() {
        return (tail + 1) % capacity == head;
    }

    private boolean isEmptyQueue() {
        return tail == head;
    }
}
