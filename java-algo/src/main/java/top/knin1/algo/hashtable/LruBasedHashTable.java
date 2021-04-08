package top.knin1.algo.hashtable;

import java.util.HashMap;

/**
 * 基于散列表的 LRU 算法
 * @author KNin1
 */
public class LruBasedHashTable<K, V> {
    /**
     * 默认链表容量
     */
    private static final int DEFAULT_CAPACITY = 8;

    /**
     * 链表头节点
     */
    private Node<K, V> head;

    /**
     * 链表尾节点
     */
    private Node<K, V> tail;

    /**
     * 链表长度
     */
    private int size = 0;

    /**
     * 链表容量
     */
    private int capacity;

    private HashMap<K, Node<K, V>> table;

    public LruBasedHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public LruBasedHashTable(int capacity) {
        this.capacity = capacity;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        table = new HashMap<>(capacity);
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        Node() {}

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 新增
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            table.put(key, newNode);
            insertNodeToTail(newNode);
            if (++size > capacity) {
                Node<K, V> headNode = popHead();
                table.remove(headNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToTail(node);
        }
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    public V get(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToTail(node);
        return node.value;
    }

    /**
     * 删除数据
     * @param key
     */
    public void remove(K key) {
        Node<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        table.remove(key);
        --size;
    }

    public void show() {
        Node<K, V> node = head.next;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 将节点加到尾部
     *
     * @param node
     */
    private void insertNodeToTail(Node<K, V> node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    /**
     * 弹出头部数据节点
     */
    private Node<K, V> popHead() {
        Node<K, V> node = head.next;
        removeNode(node);
        return node;
    }

    /**
     * 移除节点
     * @param node
     */
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点移动到尾部
     *
     * @param node
     */
    private void moveToTail(Node<K, V> node) {
        removeNode(node);
        insertNodeToTail(node);
    }

}
