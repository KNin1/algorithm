package top.knin1.algo.heap;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author KNin1
 */
public class HeapTest {
    static class Person {
        private int age;
        private String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private Comparator<Person> getComparator() {
        return Comparator.comparing(o -> o.name);
    }

    @Test
    public void testHeap() {
        Heap<Person> heap = new Heap<Person>(10, getComparator());
        heap.insert(new Person(30, "KNin1"));
        heap.insert(new Person(23, "xiaoming"));
        heap.insert(new Person(27, "laowang"));
        heap.insert(new Person(50, "Tom"));
        heap.printAll();

        System.out.println("------------ remove top ------------");
        heap.removeTop();
        heap.printAll();

        System.out.println("------------ remove top ------------");
        heap.removeTop();
        heap.printAll();
    }
}
