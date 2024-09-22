package oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu;

public class LFUCacheItem {
    private String key;
    private int frequency;
    private Integer value;

    public LFUCacheItem(){}

    public LFUCacheItem(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    public LFUCacheItem clone() {
        LFUCacheItem clonedCacheItem = new LFUCacheItem();
        clonedCacheItem.setKey(this.key);
        clonedCacheItem.setValue(this.value);
        clonedCacheItem.setFrequency(this.frequency);
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
