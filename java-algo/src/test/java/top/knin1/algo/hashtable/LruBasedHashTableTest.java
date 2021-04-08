package top.knin1.algo.hashtable;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author KNin1
 */
public class LruBasedHashTableTest {
    static class LanguageItem {
        Integer id;
        String name;

        LanguageItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "LanguageItem{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testLruBasedHashTable() {
        LruBasedHashTable<Integer, LanguageItem> lru = new LruBasedHashTable<>(4);
        lru.put(1, new LanguageItem(1, "Java"));
        lru.put(2, new LanguageItem(2, "Python"));
        lru.put(3, new LanguageItem(3, "C++"));
        lru.put(4, new LanguageItem(4, "Go"));
        Assert.assertEquals("Java", lru.get(1).name);
        lru.put(5, new LanguageItem(5, "C#"));
        Assert.assertNull(lru.get(2));
        lru.show();
    }
}
