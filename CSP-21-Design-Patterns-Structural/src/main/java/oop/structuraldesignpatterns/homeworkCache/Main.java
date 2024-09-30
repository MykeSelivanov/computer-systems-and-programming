package oop.structuraldesignpatterns.homeworkCache;

import oop.structuraldesignpatterns.homeworkCache.cacheImpl.decorator.CacheDecorator;
import oop.structuraldesignpatterns.homeworkCache.cacheImpl.decorator.CacheTimeMeasuresDecorator;
import oop.structuraldesignpatterns.homeworkCache.cacheImpl.CacheTypeEnum;
import oop.structuraldesignpatterns.homeworkCache.cacheImpl.adapter.LegacyCacheAdapter;
import oop.structuraldesignpatterns.homeworkCache.cacheImpl.proxy.CacheProxy;
import oop.structuraldesignpatterns.homeworkCache.interfaces.ICache;

import java.text.MessageFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test start");
//        testLegacyCacheAdapter();
//        testFIFOMeasureTimeCacheDecorator();
        testProxyFIFOCache();
    }

    private static void testLegacyCacheAdapter(){
        ICache<String,Integer> cache = new LegacyCacheAdapter<String,Integer>(3);
        cache.put("key1", 1); // [key1:1, ]
        cache.put("key2", 2); // [key1:1, key2:2, ]
        cache.put("key3", 3); // [key1:1, key2:2, key3:3 ]
        cache.put("key4", 4); // [key1:1, key2:2, key3:3 ]
        cache.put("key3", 4); // [key1:1, key2:2, key3:4 ]
        cache.remove("key1"); // [key2:2, key3:3 ]
        cache.put("key4", 4); // [key4:4, key2:2, key3:3 ]
    }

    private static void testFIFOMeasureTimeCacheDecorator(){
        CacheDecorator<String,Integer> decorator =
                new CacheTimeMeasuresDecorator<String,Integer>((new CacheFactory<String,Integer>()).createCacheInstance(CacheTypeEnum.FIFO, 3));
        decorator.put("key1", 1); // [key1:1, ]
        decorator.put("key2", 2); // [key1:1, key2:2, ]

        System.out.println(MessageFormat.format("Key: {0}", decorator.get("key1")));
    }

    private static void testProxyFIFOCache() {
        ICache<String, Integer> fifoCache = new CacheFactory<String, Integer>().createCacheInstance(CacheTypeEnum.FIFO, 3);
        ICache<String, Integer> proxyCache = new CacheProxy<>(fifoCache);

        proxyCache.put("key1", 1); // Logs will be printed by the proxy
        proxyCache.put("key2", 2);
        proxyCache.put("key3", 3);
        proxyCache.get("key1");     // Log the retrieval
        proxyCache.remove("key2");  // Log the removal
        proxyCache.put("key4", 4);  // Adding new key when cache is full

        System.out.println(MessageFormat.format("Cache size: {0}", proxyCache.getSize()));
    }
}
