package oop.structuraldesignpatterns.homeworkCache.interfaces;

public interface ICache<K,V> extends Iterable<K> {
    void put(K key, V value);

    V get(K key);

    void remove(K key);

    void clear();

    int getSize();

    boolean containsKey(K key);
}
