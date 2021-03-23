package top.knin1.algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class LinkedListUtilTest {
    @Test
    public void testGetMiddleNode() {
        Integer[] data = {1, 2, 5, 3, 2, 1};
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (Integer value : data) {
            linkedList.insertTail(value);
        }
        SinglyLinkedList.Node<Integer> head = linkedList.getHead();
        SinglyLinkedList.Node<Integer> middleNode = SinglyLinkedListUtils.getMiddleNode(head);
        Assert.assertEquals(5, (long) middleNode.getElement());
    }

    @Test
    public void testCheckCircle() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        String[] data = {"java", "c++", "python"};
        for (String value : data) {
            linkedList.insertTail(value);
        }
        SinglyLinkedList.Node<String> head = linkedList.getHead();
        Assert.assertFalse(SinglyLinkedListUtils.checkCircle(head));

        SinglyLinkedList.Node<String> lastNode = linkedList.findByIndex(2);
        lastNode.setNext(head);
        Assert.assertTrue(SinglyLinkedListUtils.checkCircle(head));
    }

    @Test
    public void testDeleteKthNode() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        String[] data = {"java", "c++", "python", "go", "rust"};
        for (String value : data) {
            linkedList.insertTail(value);
        }
        SinglyLinkedList.Node<String> head = linkedList.getHead();
        head = SinglyLinkedListUtils.deleteLastKth(head, 5);
        Assert.assertEquals("c++", head.getElement());
    }

    @Test
    public void testSortedLinkedListMerge() {
        SinglyLinkedList<String> l1 = new SinglyLinkedList<>();
        String[] data1 = {"c++", "go", "java", "python", "rust"};
        for (String value : data1) {
            l1.insertTail(value);
        }
        SinglyLinkedList.Node<String> head1 = l1.getHead();

        SinglyLinkedList<String> l2 = new SinglyLinkedList<>();
        String[] data2 = {"apple", "banana", "orange", "pear"};
        for (String value : data2) {
            l2.insertTail(value);
        }
        SinglyLinkedList.Node<String> head2 = l2.getHead();

        SinglyLinkedList.Node<String> merge = SinglyLinkedListUtils.mergeTwoLists(head1, head2);
        SinglyLinkedListUtils.printAll(merge);
        Assert.assertEquals(data2[0], merge.getElement());
    }
}
