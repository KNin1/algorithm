package top.knin1.algo.hashtable;

/**
 * 散列表实现
 * @author KNin1
 */
public class HashTable<K, V> {
    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    /**
     * 默认装载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 初始化散列表数组
     */
    private Entry<K, V>[] table;

    private int capacity;

    private final float factor;

    /**
     * 实际元素数量
     */
    private int size = 0;

    /**
     * 散列表索引数量
     */
    private int use = 0;

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.factor = loadFactor;
        table = (Entry<K, V>[]) new Entry[capacity];
    }

    static class Entry<K, V> {
        K key;

        V value;

        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            // 位置未被引用，创建哨兵节点
            table[index] = new Entry<>(null, null, null);
        }
        Entry<K, V> tmp = table[index];
        if (tmp.next == null) {
            tmp.next = new Entry<>(key, value, null);
            use++;
            ensureCapacity();
        } else {
            // 拉链法解决散列冲突
            do {
                tmp = tmp.next;
                // key 相同，覆盖旧数据
                if (key.equals(tmp.key)) {
                    tmp.value = value;
                    return;
                }
            } while (tmp.next != null);
            // 头插法
            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<>(key, value, temp);
        }
        size++;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> item = table[index];
        if (item == null || item.next == null) {
            return;
        }
        Entry<K, V> pre;
        Entry<K, V> headNode = table[index];
        do {
            pre = item;
            item = item.next;
            if (item.key.equals(key)) {
                pre.next = item.next;
                size--;
                if (headNode.next == null) {
                    use--;
                }
                return;
            }
        } while (item.next != null);
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> item = table[index];
        if (item == null || item.next == null) {
            return null;
        }
        while (item.next != null) {
            item = item.next;
            if (item.key.equals(key)) {
                return item.value;
            }
        }
        return null;
    }

    /**
     * 散列函数
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % capacity;
    }

    private void ensureCapacity() {
        if (use < capacity * factor) {
            return;
        }
        resize();
    }

    /**
     * 扩容
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        capacity <<= 1;
        table = (Entry<K, V>[]) new Entry[capacity];
        use = 0;
        for (Entry<K, V> kvEntry : oldTable) {
            if (kvEntry == null || kvEntry.next == null) {
                continue;
            }
            Entry<K, V> item = kvEntry;
            while (item.next != null) {
                item = item.next;
                int index = hash(item.key);
                if (table[index] == null) {
                    use++;
                    // 创建哨兵节点
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(item.key, item.value, table[index].next);
            }
        }
    }
}
