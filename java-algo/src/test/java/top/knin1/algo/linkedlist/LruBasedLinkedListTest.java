package top.knin1.algo.linkedlist;

import org.junit.Test;

/**
 * @author KNin1
 */
public class LruBasedLinkedListTest {
    @Test
    public void testLru() {
        String[] data = {"c++", "go", "java", "python", "rust", "java", "javascript"};
        LruBaseLinkedList<String> lru = new LruBaseLinkedList<>();
        for (String value : data) {
            lru.add(value);
        }
        SinglyLinkedListUtils.printAll(lru.getAllData().getHead());
    }
}
