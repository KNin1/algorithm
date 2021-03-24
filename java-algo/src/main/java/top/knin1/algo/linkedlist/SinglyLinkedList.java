package top.knin1.algo.linkedlist;

/**
 * 单链表的插入、删除、查找操作
 * @author : KNin1
 * @date : 2021-03-21
 */
public class SinglyLinkedList<T> {
    private Node<T> head = null;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> findByValue(T value) {
        Node<T> p = head;
        while (p != null && p.getElement() != value) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 查找 element 等于 value 的结点的前一个结点
     * @param value
     * @return
     */
    public Node<T> findPrevNode(T value) {
        if (head == null) {
            return null;
        }
        Node<T> p = head;
        while (p.getNext() != null) {
            if (value.equals(p.getNext().getElement())) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    public Node<T> findByIndex(int index) {
        Node<T> p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            ++pos;
        }
        return p;
    }

    /**
     * 链表头部插入
     *
     * @param value be inserted
     */
    public void insertToHead(T value) {
        Node<T> newNode = new Node<>(value, null);
        insertToHead(newNode);
    }

    /**
     * 在链表头部插入一个结点
     */
    public void insertToHead(Node<T> newNode) {
        if (newNode == null) {
            return;
        }
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * 链表尾部插入
     *
     * @param value be inserted
     */
    public void insertTail(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> p = head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(newNode);
    }

    public void insertAfter(Node<T> p, T value) {
        Node<T> newNode = new Node<>(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 在指定结点后新插入一个结点
     */
    public void insertAfter(Node<T> p, Node<T> newNode) {
        if (p == null || newNode == null) {
            return;
        }
        newNode.setNext(p.getNext());
        p.setNext(newNode);
    }

    public void insertBefore(Node<T> p, Node<T> newNode) {
        if (p == null) {
            return;
        }
        if (p == head) {
            insertToHead(newNode);
            return;
        }
        Node<T> q = head;
        while (q != null && q.getNext() != p) {
            q = q.getNext();
        }
        if (q != null) {
            newNode.setNext(p);
            q.setNext(newNode);
        }
        // q == null 链表遍历完毕，没找到对应的 p
    }

    public void deleteByNode(Node<T> p) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            head = head.getNext();
            return;
        }
        Node<T> q = head;
        while (q != null && q.getNext() != p) {
            q = q.getNext();
        }
        if (q != null) {
            q.setNext(p.getNext());
            p.setNext(null);
        }
    }

    /**
     * 删除第一个等于 value 的结点
     * @param value
     */
    public void deleteFirstNodeByValue(T value) {
        if (head == null) {
            return;
        }
        Node<T> currentNode = head;
        Node<T> preNode = null;
        while (currentNode != null && value.equals(currentNode.getNext().getElement())) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return;
        }
        if (preNode == null) {
            // delete head Node
            head = head.getNext();
        } else {
            preNode.setNext(currentNode.getNext());
        }
    }

    /**
     * 删除等于 value 的全部结点
     * @param value
     */
    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }
        if (value.equals(head.getElement())) {
            head = head.getNext();
        }
        Node<T> p = head;
        while (p != null) {
            if (p.getNext() != null && value.equals(p.getNext().getElement())) {
                p.setNext(p.getNext().getNext());
            }
            p = p.getNext();
        }
    }

    /**
     * 删除结点 p 的下一个结点
     * @param p
     */
    public void deleteNextNode(Node<T> p) {
        if (p == null || p.getNext() == null) {
            return;
        }
        p.setNext(p.getNext().getNext());
    }

    /**
     * 删除链表尾结点
     */
    public void deleteTailNode() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Node<T> p = head;
        while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        p.setNext(null);
    }

    public void printAll() {
        Node<T> p = head;
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
