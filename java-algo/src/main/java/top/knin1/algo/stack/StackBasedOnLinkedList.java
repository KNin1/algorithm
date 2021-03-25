package top.knin1.algo.stack;

import top.knin1.algo.linkedlist.SinglyLinkedList;

/**
 * 基于单链表实现栈
 * @author KNin1
 */
public class StackBasedOnLinkedList<T> {
    private int size = 0;
    private SinglyLinkedList.Node<T> top;

    public void push(T value) {
        SinglyLinkedList.Node<T> newNode = new SinglyLinkedList.Node<>(value);
        if (top != null) {
            newNode.setNext(top);
        }
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.getElement();
        top = top.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

}
