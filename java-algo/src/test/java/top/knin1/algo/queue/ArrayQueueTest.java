package top.knin1.algo.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class ArrayQueueTest {
    @Test
    public void testQueueEmpty() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testQueueFull() {
        ArrayQueue<String> queue = new ArrayQueue<>(3);
        queue.enqueue("c++");
        queue.enqueue("java");
        queue.enqueue("python");
        Assert.assertEquals("c++", queue.dequeue());

        queue.enqueue("go");
        Assert.assertFalse(queue.enqueue("c++"));
    }
}
