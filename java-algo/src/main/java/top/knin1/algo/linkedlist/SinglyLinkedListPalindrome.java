package top.knin1.algo.linkedlist;

/**
 * @author KNin1
 */
public class SinglyLinkedListPalindrome<T> {
    private final SinglyLinkedList.Node<T> head;

    SinglyLinkedListPalindrome(T[] data) {
        SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();
        for (T value : data) {
            linkedList.insertTail(value);
        }
        head = linkedList.getHead();
    }

    public SinglyLinkedList.Node<T> getHead() {
        return this.head;
    }

    public boolean palindrome() {
        if (head == null) {
            return false;
        }

        if (head.getNext() == null) {
            // 只有一个元素
            return true;
        }

        SinglyLinkedList.Node<T> p = head;
        SinglyLinkedList.Node<T> q = head;
        while (q.getNext() != null && q.getNext().getNext() != null) {
            p = p.getNext();
            q = q.getNext().getNext();
        }
        SinglyLinkedList.Node<T> leftList;
        SinglyLinkedList.Node<T> rightList;
        if (q.getNext() == null) {
            // p 一定为整个链表的中点，且节点数目为奇数
            rightList = p.getNext();
            leftList = SinglyLinkedListUtils.reverse(p).getNext();
        } else {
            // p 和 p 的下一个节点均为中点
            rightList = p.getNext();
            leftList = SinglyLinkedListUtils.reverse(p);
        }
        return sameLinkedList(leftList, rightList);
    }

    private boolean sameLinkedList(SinglyLinkedList.Node<T> left, SinglyLinkedList.Node<T> right) {
        SinglyLinkedList.Node<T> l = left;
        SinglyLinkedList.Node<T> r = right;
        while (l != null && r != null) {
            if (l.getElement().equals(r.getElement())) {
                l = l.getNext();
                r = r.getNext();
            } else {
                break;
            }
        }
        return l == null && r == null;
    }
}
