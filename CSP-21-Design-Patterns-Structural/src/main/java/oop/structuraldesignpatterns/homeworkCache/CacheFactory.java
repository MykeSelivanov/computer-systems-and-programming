package oop.structuraldesignpatterns.homeworkCache;

import oop.structuraldesignpatterns.homeworkCache.cacheImpl.CacheTypeEnum;
import oop.structuraldesignpatterns.homeworkCache.cacheImpl.FIFOCache;
import oop.structuraldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;

public class CacheFactory<K,V> {
    public ICache<K,V> createCacheInstance(CacheTypeEnum type, int capacity) {
        switch (type) {
            case CacheTypeEnum.FIFO:
                return new FIFOCache<K,V>(capacity);
            default:
                System.out.println(MessageFormat.format("cache with type {0} is not implemented yet.", type));
                return null;
        }
    }
}
