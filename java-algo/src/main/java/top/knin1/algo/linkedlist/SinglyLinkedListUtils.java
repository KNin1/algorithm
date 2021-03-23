package top.knin1.algo.linkedlist;

import java.util.Comparator;

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
        while (cur != null) {
            SinglyLinkedList.Node<T> next = cur.getNext();
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

    /**
     * 获取链表中间结点
     */
    public static <T> SinglyLinkedList.Node<T> getMiddleNode(SinglyLinkedList.Node<T> p) {
        if (p == null || p.getNext() == null || p.getNext().getNext() == null) {
            return p;
        }

        SinglyLinkedList.Node<T> fast = p;
        SinglyLinkedList.Node<T> slow = p;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * 检测链表中是否有环
     */
    public static <T> boolean checkCircle(SinglyLinkedList.Node<T> p) {
        if (p == null || p.getNext() == null) {
            return false;
        }
        SinglyLinkedList.Node<T> fast = p;
        SinglyLinkedList.Node<T> slow = p;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除链表倒数第 k 个结点
     */
    public static <T> SinglyLinkedList.Node<T> deleteLastKth(SinglyLinkedList.Node<T> p, int k) {
        if (p == null || k <= 0) {
            return p;
        }
        int index = 0;
        SinglyLinkedList.Node<T> fast = p;
        while (fast != null && index < k) {
            fast = fast.getNext();
            ++index;
        }
        if (fast == null) {
            if (index < k) {
                return p;
            }
            SinglyLinkedList.Node<T> temp = p;
            p = p.getNext();
            temp.setNext(null);
            temp = null;
            return p;
        }

        SinglyLinkedList.Node<T> slow = p;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return p;
    }

    /**
     * 合并两个有序链表
     */
    public static <T extends Comparable<T>> SinglyLinkedList.Node<T> mergeTwoLists(SinglyLinkedList.Node<T> l1,
                                                                                   SinglyLinkedList.Node<T> l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        SinglyLinkedList.Node<T> soldier = new SinglyLinkedList.Node<>();
        SinglyLinkedList.Node<T> p = soldier;
        while (l1 != null && l2 != null) {
            if (l1.getElement().compareTo(l2.getElement()) > 0) {
                p.setNext(l2);
                l2 = l2.getNext();
            } else {
                p.setNext(l1);
                l1 = l1.getNext();
            }
            p = p.getNext();
        }
        if (l1 != null) {
            p.setNext(l1);
        }
        if (l2 != null) {
            p.setNext(l2);
        }
        return soldier.getNext();
    }

    public static <T> void printAll(SinglyLinkedList.Node<T> p) {
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}
