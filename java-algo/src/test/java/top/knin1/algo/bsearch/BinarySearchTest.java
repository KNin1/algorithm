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
}
