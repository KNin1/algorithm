package top.knin1.algo.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class QueueBasedOnLinkedListTest {
    @Test
    public void testQueueBasedOnLinkedList() {
        QueueBasedOnLinkedList<String> queue = new QueueBasedOnLinkedList<>();
        Assert.assertNull(queue.dequeue());
        queue.enqueue("java");
        queue.enqueue("python");
        Assert.assertEquals("java", queue.dequeue());
    }
}
