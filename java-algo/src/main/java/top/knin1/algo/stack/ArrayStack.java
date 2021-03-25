package top.knin1.algo.stack;

import java.util.Objects;

/**
 * 基于数组实现栈（顺序栈）
 * @author KNin1
 * 2021-03-25
 */
public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private final Object[] items;
    private final int capacity;
    private int top;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
        this.items = new Object[this.capacity];
    }

    public boolean push(T data) {
        if (top == capacity) {
            return false;
        }
        items[top++] = data;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == 0) {
            return null;
        }
        return (T) items[--top];
    }
}
