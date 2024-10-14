package oop.behavioraldesignpatterns.homeworkCache.commands;

import oop.behavioraldesignpatterns.homeworkCache.interfaces.ICache;

public class RemoveCommand<K,V> extends CacheCommand<K,V> {
    private K key;
    private V removedValue;

    public RemoveCommand(ICache<K, V> cache, K key) {
        super(cache);
        this.key = key;
    }

    @Override
    public void execute() {
        // store removed value for undo
        removedValue = cache.get(key);
        cache.remove(key);
    }

    @Override
    public void undo() {
        if (removedValue != null) {
            cache.put(key, removedValue);
        }
    }
}
