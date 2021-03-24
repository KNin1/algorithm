package top.knin1.algo.linkedlist;

/**
 * 基于单链表实现 LRU 策略
 * @author KNin1
 * 2021-03-24
 */
public class LruBaseLinkedList<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private int size;
    private int capacity;
    private SinglyLinkedList<T> list;

    public LruBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LruBaseLinkedList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.list = new SinglyLinkedList<>();
    }

    protected SinglyLinkedList<T> getAllData() {
        return this.list;
    }

    public void add(T data) {
        SinglyLinkedList.Node<T> prevNode = list.findPrevNode(data);
        if (prevNode == null) {
            if (size >= capacity) {
                deleteTailNode();
            }
        } else {
            deleteNextNode(prevNode);
        }
        insertListHead(data);
    }

    private void insertListHead(T data) {
        list.insertToHead(data);
        size++;
    }

    private void deleteTailNode() {
        list.deleteTailNode();
        size--;
    }

    private void deleteNextNode(SinglyLinkedList.Node<T> p) {
        list.deleteNextNode(p);
        size--;
    }
}
