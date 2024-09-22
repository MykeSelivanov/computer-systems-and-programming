package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu;

import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache implements ICache {
    private int capacity;
    private String serverName;
    // {String key:LFUCacheItem} or {String key: {String sameKey, int value, int frequency}}
    // cache: {key1:{key1, 6, 2}}, {key2:{key2, 2, 1}}, {key3:{3, 2}}
    private final Map<String, LFUCacheItem> keyToCacheItemMap;
    // {LFUCacheItem} [{key2: 1}, {key1: 2}, {key3: 2}]-
    // frequencies heap, will keep the least frequently used on top
    private final PriorityQueue<LFUCacheItem> keyFrequenciesMinHeap;

    public LFUCache() {
        this.capacity = 10; // by default
        this.keyToCacheItemMap = new HashMap<>();
        this.keyFrequenciesMinHeap = new PriorityQueue<>(Comparator.comparingInt(LFUCacheItem::getFrequency));
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public void clear() {
        keyToCacheItemMap.clear();
        keyFrequenciesMinHeap.clear();
    }

    @Override
    public int getSize() {
        return keyToCacheItemMap.size();
    }

    @Override
    public boolean containsKey(String key) {
        return keyToCacheItemMap.containsKey(key);
    }

    @Override
    public void put(String key, Integer value) {
        // If the item with this key already exists, need to update the value
        // and bump the frequency
        if (containsKey(key)) {
            LFUCacheItem itemToUpdate = keyToCacheItemMap.get(key);
            LFUCacheItem clonedItem = itemToUpdate.clone();
            clonedItem.setValue(value);
            keyToCacheItemMap.put(clonedItem.getKey(), clonedItem);
            increaseCacheItemFrequency(itemToUpdate, clonedItem);
            return;
        }

        // Add to the cache in case the key is new
        // Check for capacity before adding, if the map size is equal to capacity
        // then least frequently used item should be removed from both map and heap
        while (getSize() >= capacity) {
            LFUCacheItem itemWithMinFrequency = keyFrequenciesMinHeap.poll();
            keyToCacheItemMap.remove(itemWithMinFrequency.getKey());
        }

        // add an item to the cache and the heap with default frequency
        LFUCacheItem itemToAdd = new LFUCacheItem(key, value);
        keyToCacheItemMap.put(itemToAdd.getKey(), itemToAdd);
        keyFrequenciesMinHeap.add(itemToAdd);
    }

    @Override
    public Integer get(String key) {
        // If item from the cache is used, it's frequency should be increased
        if (containsKey(key)) {
            LFUCacheItem cacheItem = keyToCacheItemMap.get(key);
            LFUCacheItem clonedItem = cacheItem.clone();
            keyToCacheItemMap.put(clonedItem.getKey(), clonedItem);
            increaseCacheItemFrequency(cacheItem, clonedItem);
            return clonedItem.getValue();
        }
        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        return null;
    }

    @Override
    public void remove(String key) {
        if(containsKey(key)) {
            LFUCacheItem itemToRemove = keyToCacheItemMap.get(key);
            keyToCacheItemMap.remove(itemToRemove.getKey());
            keyFrequenciesMinHeap.remove(itemToRemove);
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        }
    }

    private void increaseCacheItemFrequency(LFUCacheItem itemToDelete, LFUCacheItem itemToAdd) {
        keyFrequenciesMinHeap.remove(itemToDelete);
        itemToAdd.setFrequency(itemToAdd.getFrequency() + 1);
        keyFrequenciesMinHeap.add(itemToAdd);
    }
}
