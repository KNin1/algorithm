package top.knin1.algo.queue;

import top.knin1.algo.linkedlist.SinglyLinkedList;

/**
 * 基于链表实现队列（链式队列）
 * @author KNin1
 * 2021-03-26
 */
public class QueueBasedOnLinkedList<T> {
    private SinglyLinkedList.Node<T> head;
    private SinglyLinkedList.Node<T> tail;

    public void enqueue(T data) {
        if (tail == null) {
            SinglyLinkedList.Node<T> node = new SinglyLinkedList.Node<>(data, null);
            tail = node;
            head = node;
        } else {
            tail.setNext(new SinglyLinkedList.Node<>(data, null));
            tail = tail.getNext();
        }
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T value = head.getElement();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return value;
    }

}
