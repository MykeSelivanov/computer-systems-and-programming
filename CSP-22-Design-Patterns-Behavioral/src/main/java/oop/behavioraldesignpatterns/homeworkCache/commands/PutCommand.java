package oop.behavioraldesignpatterns.homeworkCache.commands;

import oop.behavioraldesignpatterns.homeworkCache.interfaces.ICache;

public class PutCommand<K,V> extends CacheCommand<K,V>{
    private K key;
    private V value;
    private V previousValue;

    public PutCommand(ICache<K, V> cache, K key, V value) {
        super(cache);
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        // store the old value for undo
        previousValue = cache.get(key);
        cache.put(key, value);
    }

    @Override
    public void undo() {
        if (previousValue != null) {
            cache.put(key, previousValue);
        } else {
            cache.remove(key);
        }
    }
}
