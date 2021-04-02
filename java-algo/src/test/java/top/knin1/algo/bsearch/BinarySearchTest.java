package top.knin1.algo.bsearch;

import org.junit.Assert;
import org.junit.Test;
import top.knin1.algo.sort.InsertSort;

public class BinarySearchTest {
    @Test
    public void testSimpleBinarySearch() {
        int[] arr = {10, 90, 2, 100, 212, 345};
        InsertSort.sort(arr, arr.length);
        int index = BinarySearch.search(arr, 100);
        Assert.assertEquals(3, index);
    }

    @Test
    public void testSearchFirstEqualElement() {
        int[] arr = {10, 90, 2, 100, 100, 82, 345, 100};
        InsertSort.sort(arr, arr.length);
        // {2, 10, 82, 90, 100, 100, 100, 345}
        int index = BinarySearch.searchFirstEqualElement(arr, 100);
        Assert.assertEquals(4, index);
    }

    @Test
    public void testSearchLastEqualElement() {
        int[] arr = {10, 90, 2, 100, 100, 82, 345, 100};
        InsertSort.sort(arr, arr.length);
        int index = BinarySearch.searchLastEqualElement(arr, 100);
        Assert.assertEquals(6, index);
    }

    @Test
    public void testsearchFirstGreaterOrEqualElement() {
        int[] arr = {10, 90, 2, 100, 100, 82, 345, 100};
        InsertSort.sort(arr, arr.length);
        int index = BinarySearch.searchFirstGreaterOrEqualElement(arr, 100);
        Assert.assertEquals(4, index);
    }

    @Test
    public void testsearchLastLessOrEqualElement() {
        int[] arr = {10, 90, 2, 100, 100, 82, 345, 100};
        InsertSort.sort(arr, arr.length);
        int index = BinarySearch.searchLastLessOrEqualElement(arr, 100);
        Assert.assertEquals(6, index);
    }

}
