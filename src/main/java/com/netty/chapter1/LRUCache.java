package com.netty.chapter1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yanglun
 * @description: test lru
 * @date 2019/5/24 20:26
 */
public class LRUCache extends LinkedHashMap {

    private int capacity;

    public LRUCache(int initialCapacity) {
        super(16, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        System.out.println(eldest.getKey() + "=" + eldest.getValue());
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(9,3);
        lruCache.put(7,4);
        lruCache.put(5,9);
        lruCache.put(3,4);
        lruCache.put(6,6);

        for(Iterator<Map.Entry<Integer,Integer>> it = lruCache.entrySet().iterator(); it.hasNext();){
            System.out.println(it.next().getKey());
        }
    }
}


