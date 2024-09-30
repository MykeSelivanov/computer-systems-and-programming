package oop.structuraldesignpatterns.homeworkCache.cacheImpl.proxy;

import oop.structuraldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;
import java.util.Iterator;

public class CacheProxy<K, V> implements ICache<K, V> {
    private final ICache<K, V> cache;

    public CacheProxy(ICache<K, V> cache) {
        this.cache = cache;
    }

    @Override
    public void put(K key, V value) {
        System.out.println(MessageFormat.format("Proxy: Adding key {0} with value {1} to the cache", key, value));
        cache.put(key, value);
    }

    @Override
    public V get(K key) {
        System.out.println(MessageFormat.format("Proxy: Retrieving value for key {0}", key));
        return cache.get(key);
    }

    @Override
    public void remove(K key) {
        System.out.println(MessageFormat.format("Proxy: Removing key {0} from the cache", key));
        cache.remove(key);
    }

    @Override
    public void clear() {
        System.out.println("Proxy: Clearing the cache");
        cache.clear();
    }

    @Override
    public int getSize() {
        return cache.getSize();
    }

    @Override
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    @Override
    public Iterator<K> iterator() {
        return cache.iterator();
    }
}
