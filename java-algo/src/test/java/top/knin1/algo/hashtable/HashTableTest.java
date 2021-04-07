package top.knin1.algo.hashtable;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class HashTableTest {
    @Test
    public void testHashTable() {
        HashTable<String, String> hashTable = new HashTable<>(4);
        hashTable.put("name", "KNin");
        hashTable.put("email", "wangcpps@gmail.com");
        hashTable.put("addresses", "shanxi xi'an");
        hashTable.put("cellphone", "111111");
        hashTable.put("name", "KNin1");

        Assert.assertEquals("KNin1", hashTable.get("name"));
        Assert.assertNull(hashTable.get("age"));
        Assert.assertEquals(8, hashTable.getCapacity());
    }
}
