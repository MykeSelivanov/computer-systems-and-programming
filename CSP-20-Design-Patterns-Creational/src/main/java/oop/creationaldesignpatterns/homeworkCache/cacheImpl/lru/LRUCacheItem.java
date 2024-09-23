package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru;

public class LRUCacheItem {
    private String key;
    private Integer value;
    public LRUCacheItem next, previous;

    public LRUCacheItem() {}

    public LRUCacheItem(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public LRUCacheItem clone() {
        LRUCacheItem clonedCacheItem = new LRUCacheItem();
        clonedCacheItem.setKey(this.key);
        clonedCacheItem.setValue(this.value);
        return clonedCacheItem;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
