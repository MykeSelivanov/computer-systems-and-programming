package oop.structuraldesignpatterns.homeworkCache.cacheImpl.decorator;

import oop.structuraldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;

public class CacheTimeMeasuresDecorator<K,V> extends CacheDecorator<K,V>{
    public CacheTimeMeasuresDecorator(ICache<K,V> cache) {
        super(cache);
    }

    @Override
    public V get(K key) {
        long startTime = System.nanoTime();
        V cacheValue = super.get(key);
        long endTime = System.nanoTime();
        System.out.println(MessageFormat.format("Retrieved value for key: {0} in {1} ms", key, (endTime - startTime) / 1000000.0));

        return cacheValue;
    }
}
