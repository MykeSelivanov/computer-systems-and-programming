package oop.behavioraldesignpatterns.homeworkCache.commands;

import oop.behavioraldesignpatterns.homeworkCache.interfaces.ICache;

public abstract class CacheCommand<K, V> {
    protected ICache<K, V> cache;

    public CacheCommand(ICache<K, V> cache) {
        this.cache = cache;
    }

    public abstract void execute();
    public abstract void undo();
}
