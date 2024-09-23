package oop.creationaldesignpatterns.homeworkCache;

import oop.creationaldesignpatterns.homeworkCache.cacheImpl.CacheTypeEnum;
import oop.creationaldesignpatterns.homeworkCache.cacheImpl.fifo.FIFOCache;
import oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu.LFUCache;
import oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu.LFUCacheBuilder;
import oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru.LRUCacheBuilder;
import oop.creationaldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;

public class CacheFactory {
    public static ICache createCacheInstance(CacheTypeEnum type, int capacity) {
        switch (type) {
            case CacheTypeEnum.FIFO:
                return new FIFOCache(capacity);
            case CacheTypeEnum.LFU:
                LFUCacheBuilder lfuCacheBuilder = new LFUCacheBuilder().setCapacity(capacity).setServerName("localhost::8080");
                return lfuCacheBuilder.build();
            case CacheTypeEnum.LRU:
                return new LRUCacheBuilder().setCapacity(3).serServerName("localhost::5050").build();
            default:
                System.out.println(MessageFormat.format("cache with type {0} is not implemented yet.", type));
                return null;
        }
    }
}

