package top.knin1.algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class PalindromeTest {
    @Test
    public void testNotPalindromeInteger() {
        Integer[] data = {1, 2, 5, 3, 2, 1};
        SinglyLinkedListPalindrome<Integer> palindrome = new SinglyLinkedListPalindrome<>(data);
        SinglyLinkedListUtils.printAll(palindrome.getHead());
        Assert.assertFalse(palindrome.palindrome());
    }

    @Test
    public void testPalindromeString() {
        String[] data = {"abc", "d", "cat", "d", "abc"};
        SinglyLinkedListPalindrome<String> palindrome = new SinglyLinkedListPalindrome<>(data);
        SinglyLinkedListUtils.printAll(palindrome.getHead());
        Assert.assertTrue(palindrome.palindrome());
    }
}
