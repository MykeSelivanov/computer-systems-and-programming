package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu;

import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache implements ICache {
    private int capacity;
    private String serverName;
    private final Map<String, LFUCacheItem> keyToCacheItemMap;
    private final PriorityQueue<LFUCacheItem> keyFrequencesMinHeap;


}
