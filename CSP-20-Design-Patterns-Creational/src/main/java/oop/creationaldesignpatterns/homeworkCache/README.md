# Homework Cache System

This repository demonstrates the use of various **caching mechanisms** (FIFO, LFU, LRU) implemented using **creational design patterns**. The project also includes a cache factory that allows dynamic creation of cache instances based on user input.

## Table of Contents

- [Overview](#overview)
- [Cache Implementations](#cache-implementations)
    - [FIFO Cache](#fifo-cache)
    - [LFU Cache](#lfu-cache)
    - [LRU Cache](#lru-cache)
- [Design Patterns Used](#design-patterns-used)

## Overview

The Homework Cache system allows the creation of caches using different algorithms:

- [**FIFO (First-In-First-Out)**](cacheImpl/fifo)
- [**LFU (Least Frequently Used)**](cacheImpl/lfu)
- [**LRU (Least Recently Used)**](cacheImpl/lru)

The caches are implemented following the `ICache` interface, which defines the essential methods for working with caches, such as `put`, `get`, `remove`, `clear`, etc.

## Cache Implementations

### FIFO Cache

The **FIFO (First-In-First-Out)** cache removes the oldest entry when the cache exceeds its capacity. It uses a queue to maintain the order of entries.

- Package: `oop.creationaldesignpatterns.homeworkCache.cacheImpl.fifo`
- Class: `FIFOCache`
- Capacity management: Oldest entry is removed when the cache is full.

### LFU Cache

The **LFU (Least Frequently Used)** cache evicts the least frequently accessed entry when it reaches its capacity. The cache maintains a frequency count for each entry.

- Package: `oop.creationaldesignpatterns.homeworkCache.cacheImpl.lfu`
- Class: `LFUCache`
- Capacity management: Entries with the lowest frequency are removed.

**LFU Cache Builder**: This cache also supports a builder pattern for flexible configuration (e.g., setting capacity or server name).

### LRU Cache

The **LRU (Least Recently Used)** cache evicts the least recently accessed entry. It maintains an internal doubly linked list to track the most and least recently used items.

- Package: `oop.creationaldesignpatterns.homeworkCache.cacheImpl.lru`
- Class: `LRUCache`
- Capacity management: Least recently accessed entry is removed.

**LRU Cache Builder**: Like LFU, LRU cache supports a builder pattern for custom configurations.

## Design Patterns Used

- **Factory Pattern**: The `CacheFactory` is used to instantiate caches dynamically based on the cache type (FIFO, LFU, LRU).
- **Builder Pattern**: Both LFU and LRU caches can be built using a builder for easier configuration.
- **Singleton Pattern**: The `CacheFactory` ensures only one instance of a cache is created per type.