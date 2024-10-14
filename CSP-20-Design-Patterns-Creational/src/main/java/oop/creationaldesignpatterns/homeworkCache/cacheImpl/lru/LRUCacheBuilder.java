package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru;

public class LRUCacheBuilder {
    private LRUCache lruCache;

    public LRUCacheBuilder() {
        lruCache = new LRUCache();
    }

    public LRUCacheBuilder setCapacity(int capacity) {
        lruCache.setCapacity(capacity);
        return this;
    }

    public LRUCacheBuilder serServerName(String serverName) {
        lruCache.setServerName(serverName);
        return this;
    }

    public LRUCache build() {
        return lruCache;
    }
}
