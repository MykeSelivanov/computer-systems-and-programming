package oop.creationaldesignpatterns.homeworkCache.cacheImpl.fifo;

import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FIFOCache implements ICache {
    private final int capacity;
    private final Map<String, Integer> cacheMap;
    private final Queue<String> orderQueue;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.orderQueue = new LinkedList<>();
    }

    @Override
    public void put(String key, Integer value) {
        if (containsKey(key)) {
            cacheMap.put(key, value);
            // update the key in the queue
            orderQueue.remove(key);
            orderQueue.add(key);
        } else {
            while (getSize() >= capacity) {
                // remove the oldest element from the cache and queue
                String oldestItemKey = orderQueue.poll();
                cacheMap.remove(oldestItemKey);
            }
            cacheMap.put(key, value);
            orderQueue.add(key);
        }
    }

    @Override
    public Integer get(String key) {
        if (containsKey(key)){
            return cacheMap.get(key);
        }
        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        return null;
    }

    @Override
    public void remove(String key) {
        if (containsKey(key)) {
            cacheMap.remove(key);
            orderQueue.remove(key);
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        }
    }

    @Override
    public void clear() {
        cacheMap.clear();
        orderQueue.clear();
    }

    @Override
    public int getSize() {
        return cacheMap.size();
    }

    @Override
    public boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }
}
