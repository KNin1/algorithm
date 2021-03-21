package top.knin1.algo.array;

/**
 * int 型基本数组的创建、访问
 * @author : KNin1
 * @date : 2021-03-21
 */
public class Array {
    private int [] data;
    // 数组长度
    private int size;
    // 数组中元素的实际个数
    private int count;

    public Array(int capacity) {
        this.size = capacity;
        this.data = new int[this.size];
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("插入位置错误");
        }
        return data[index];
    }

    public void insert(int index, int value) {
        if (size == count) {
            System.out.println("数组已满，没有插入位置");
        }
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("插入位置错误");
        }
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
    }

    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("插入位置错误");
        }
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        array.delete(1);
        array.printAll();
    }
}
