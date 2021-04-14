package top.knin1.algo.heap;

import org.junit.Assert;
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
    public void testMaxHeap() {
        Heap<Person> heap = new MaxHeap<>(10, getComparator());
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

    @Test
    public void testHeapSort() {
        Person[] persons = {
            new Person(30, "KNin1"),
            new Person(23, "xiaoming"),
            new Person(27, "laowang"),
            new Person(50, "Tom")
        };
        HeapSort<Person> sorter = new HeapSort<>(getComparator());
        sorter.sort(persons);
        for (Person person : persons) {
            System.out.println(person);
        }

        Assert.assertEquals("KNin1", persons[0].name);
    }

    @Test
    public void testMinHeap() {
        Heap<Person> heap = new MinHeap<>(10, getComparator());
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

    @Test
    public void testTopK() {
        Person[] persons = {
                new Person(30, "KNin1"),
                new Person(23, "xiaoming"),
                new Person(27, "laowang"),
                new Person(50, "Tom")
        };
        Object[] topK = TopK.solution(persons, getComparator(), 3);
        for (Object person : topK) {
            System.out.println(person);
        }
        Assert.assertEquals("Tom", ((Person) topK[0]).name);
    }
}
