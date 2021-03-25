package top.knin1.algo.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class CircularQueueTest {
    @Test
    public void testCircularEmpty() {
        CircularQueue<Object> queue = new CircularQueue<>(3);
        queue.enqueue("c++");
        queue.enqueue("java");
        Assert.assertFalse(queue.enqueue("python"));
        Assert.assertEquals("c++", queue.dequeue());
        Assert.assertEquals("java", queue.dequeue());
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testCircularQueueFull() {
        CircularQueue<Object> queue = new CircularQueue<>(3);
        queue.enqueue("c++");
        queue.enqueue("java");
        Assert.assertFalse(queue.enqueue("python"));
    }
}
