package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru;

import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements ICache {
    private int capcity;
    private String serverName;
    private final Map<String, LRUCacheItem> keyToCacheMap;
    private LRUCacheItem head, tail;
    private int size;

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public LRUCache() {
        this.capcity = capcity;
        this.keyToCacheMap = new HashMap<>();
        this.size = 0;
        // Create dummy head and tail
        head = new LRUCacheItem();
        tail = new LRUCacheItem();
        head.next = tail;
        tail.previous = head;
    }

    // add most recently used item to the front
    private void addToFront(LRUCacheItem item) {
        item.next = head.next;
        item.previous = head;
        head.next.previous = item;
        head.next = item;
        size++;
    }

    // remove item from the list
    private void remove(LRUCacheItem item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
        size--;
    }

    // remove the least recently used item
    private LRUCacheItem removeLast() {
        if (size == 0) return null;
        LRUCacheItem lastItem = tail.previous;
        remove(lastItem);
        return lastItem;
    }

    @Override
    public void put(String key, Integer value) {
        if (keyToCacheMap.containsKey(key)) {
            // if item with this key already exists, update the value
            LRUCacheItem existingItem = keyToCacheMap.get(key);
            existingItem.setValue(value);
            remove(existingItem);
            addToFront(existingItem);
        } else {
            while (size >= capcity) {
                // remove the least recently used item
                LRUCacheItem leastRecentlyUsed = removeLast();
                if (leastRecentlyUsed != null) {
                    keyToCacheMap.remove(leastRecentlyUsed.getKey());
                }
            }
            LRUCacheItem itemToAdd = new LRUCacheItem(key, value);
            addToFront(itemToAdd);
            keyToCacheMap.put(key, itemToAdd);
        }
    }

    @Override
    public Integer get(String key) {
        if (!keyToCacheMap.containsKey(key)) {
            return null;
        }
        LRUCacheItem item = keyToCacheMap.get(key);
        remove(item);
        addToFront(item);
        return item.getValue();
    }

    @Override
    public void remove(String key) {
        if (keyToCacheMap.containsKey(key)) {
            LRUCacheItem item = keyToCacheMap.get(key);
            remove(item);
            keyToCacheMap.remove(key);
        }
    }

    @Override
    public void clear() {
        keyToCacheMap.clear();
        size = 0;
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean containsKey(String key) {
        return keyToCacheMap.containsKey(key);    }
}
