/*
        ✅ LRU Cache using LinkedHashMap (Simplest & Recommended)
        LinkedHashMap supports “accessOrder = true”, which automatically moves accessed entries to the end,
         helping us implement LRU with minimal code.


         🔍 How it Works

        LinkedHashMap stores keys in insertion order or access order.

        We enable access-order → whenever you call get(), the key moves to the end.

        removeEldestEntry() removes the oldest entry when size exceeds capacity.
        Both get() and put() are O(1).

        👍 Output
        {1=A, 2=B, 3=C}
        {3=C, 1=A, 4=D}
 */

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        // accessOrder = true → moves element to end on get()
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;   // remove LRU
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    public void printCache() {
        System.out.println(super.toString());
    }
}

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");
        cache.printCache(); // {1=A, 2=B, 3=C}

        cache.getValue(1);  // Makes 1 most recently used
        cache.putValue(4, "D"); // Removes LRU → key 2
        cache.printCache(); // {3=C, 1=A, 4=D}
    }
}
