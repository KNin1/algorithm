package top.knin1.algo.linkedlist;

/**
 * @author KNin1
 * 基于单链表的基础操作
 */
public class SinglyLinkedListUtils {
    /**
     * 链表翻转
     * @param p linked list head node
     * @return
     */
    public static <T> SinglyLinkedList.Node<T> reverse(SinglyLinkedList.Node<T> p) {
        if (p == null || p.getNext() == null) {
            return p;
        }
        SinglyLinkedList.Node<T> prev = null;
        SinglyLinkedList.Node<T> cur = p;
        SinglyLinkedList.Node<T> next;
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 借助哨兵结点翻转链表
     * 链表翻转等价于从第二个结点开始重新头插法建立链表
     * @param p
     * @param <T>
     * @return
     */
    public static <T> SinglyLinkedList.Node<T> reverseWithHead(SinglyLinkedList.Node<T> p) {
        if (p == null || p.getNext() == null) {
            return p;
        }

        SinglyLinkedList.Node<T> tmpHead = new SinglyLinkedList.Node<>();
        tmpHead.setNext(p);
        SinglyLinkedList.Node<T> cur = p.getNext();
        p.setNext(null);
        SinglyLinkedList.Node<T> next;
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(tmpHead.getNext());
            tmpHead.setNext(cur);
            cur = next;
        }
        return tmpHead.getNext();
    }

    public static <T> void printAll(SinglyLinkedList.Node<T> p) {
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}
