package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru;

import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements ICache {
    private int capacity;
    private String serverName;
    private final Map<String, LRUCacheItem> keyToCacheMap;
    private LRUCacheItem head, tail;
    private int size;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public LRUCache() {
        this.capacity = capacity;
        this.keyToCacheMap = new HashMap<>();
        this.size = 0;
        // Create dummy head and tail
        head = new LRUCacheItem();
        tail = new LRUCacheItem();
        head.next = tail;
        tail.previous = head;
    }

    // add most recently used item to the front
    private void addToLRUTrackingListFront(LRUCacheItem item) {
        item.next = head.next;
        item.previous = head;
        head.next.previous = item;
        head.next = item;
        size++;
    }

    // remove item from the list
    private void removeFromLRUTrackingList(LRUCacheItem item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
        size--;
    }

    // remove the least recently used item
    private LRUCacheItem removeLastFromLRUTrackingList() {
        if (size == 0) return null;
        LRUCacheItem lastItem = tail.previous;
        removeFromLRUTrackingList(lastItem);
        return lastItem;
    }

    @Override
    public void put(String key, Integer value) {
        if (keyToCacheMap.containsKey(key)) {
            // if item with this key already exists, update the value
            LRUCacheItem existingItem = keyToCacheMap.get(key);
            existingItem.setValue(value);
            removeFromLRUTrackingList(existingItem);
            addToLRUTrackingListFront(existingItem);
        } else {
            while (size >= capacity) {
                // remove the least recently used item
                LRUCacheItem leastRecentlyUsed = removeLastFromLRUTrackingList();
                if (leastRecentlyUsed != null) {
                    keyToCacheMap.remove(leastRecentlyUsed.getKey());
                }
            }
            LRUCacheItem itemToAdd = new LRUCacheItem(key, value);
            addToLRUTrackingListFront(itemToAdd);
            keyToCacheMap.put(key, itemToAdd);
        }
    }

    @Override
    public Integer get(String key) {
        if (!keyToCacheMap.containsKey(key)) {
            return null;
        }
        LRUCacheItem item = keyToCacheMap.get(key);
        removeFromLRUTrackingList(item);
        addToLRUTrackingListFront(item);
        return item.getValue();
    }

    @Override
    public void remove(String key) {
        if (keyToCacheMap.containsKey(key)) {
            LRUCacheItem item = keyToCacheMap.get(key);
            removeFromLRUTrackingList(item);
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
