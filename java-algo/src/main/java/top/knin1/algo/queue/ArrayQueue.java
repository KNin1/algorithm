package top.knin1.algo.queue;

/**
 * 基于数组实现队列（顺序队列）
 * @author KNin1
 */
public class ArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 5;
    protected Object[] items;
    protected int capacity;
    protected int head;
    protected int tail;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.items = new Object[this.capacity];
    }

    /**
     * 队尾入队
     * @param data
     * @return
     */
    public boolean enqueue(T data) {
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = data;
        return true;
    }

    /**
     * 对头出队
     * @return
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return (T) items[head++];
    }
}
