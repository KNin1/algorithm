package top.knin1.algo.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class ArrayStackTest {
    @Test
    public void testStackEmpty() {
        ArrayStack<String> stack = new ArrayStack<>();
        Assert.assertNull(stack.pop());
    }

    @Test
    public void testStackFull() {
        ArrayStack<String> stack = new ArrayStack<>(3);
        stack.push("c++");
        stack.push("java");
        stack.push("python");
        Assert.assertFalse(stack.push("go"));
    }
}
