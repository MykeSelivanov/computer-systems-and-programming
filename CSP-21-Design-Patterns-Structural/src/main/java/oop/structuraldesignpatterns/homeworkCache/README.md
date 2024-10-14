# Homework Cache System

This repository demonstrates the use of various **caching mechanisms** (FIFO, Proxy, Adapter, Decorator) implemented using **structural design patterns**. The project includes a cache factory that allows dynamic creation of cache instances based on user input.

## Table of Contents

- [Overview](#overview)
- [Cache Implementations](#cache-implementations)
    - [FIFO Cache](#fifo-cache)
    - [Legacy Cache Adapter](#legacy-cache-adapter)
- [Additional Cache Features](#additional-cache-features)
    - [Cache Proxy](#cache-proxy)
    - [Cache Time Measure Decorator](#cache-time-measure-decorator)
- [Design Patterns Used](#design-patterns-used)
- [How to Run the Tests](#how-to-run-the-tests)

## Overview

The Homework Cache system provides a framework for working with different cache mechanisms:

- [**FIFO (First-In-First-Out)**](#fifo-cache)
- [**Legacy Cache Adapter**](#legacy-cache-adapter)

Each cache implements the `ICache` interface, which provides essential methods such as `put`, `get`, `remove`, `clear`, and more. The project includes additional features like cache proxies for logging operations and decorators for measuring time.

## Cache Implementations

### FIFO Cache

The **FIFO (First-In-First-Out)** cache evicts the oldest entry when the cache reaches its capacity. It uses a queue to maintain the order of entries.

- **Package**: `oop.structuraldesignpatterns.homeworkCache.cacheImpl`
- **Class**: `FIFOCache`
- **Capacity management**: When the cache is full, the oldest entry is removed.

### Legacy Cache Adapter

The **Legacy Cache Adapter** adapts an old cache system (`LegacyCache`) to fit modern cache standards and constraints like capacity limits.

- **Package**: `oop.structuraldesignpatterns.homeworkCache.cacheImpl.adapter`
- **Class**: `LegacyCacheAdapter`
- **Capacity management**: Manages the legacy cache by adding capacity restrictions.

### Cache Proxy
The **Cache Proxy** provides logging and validation of cache operations. It wraps around any cache implementation and logs actions like put, get, remove, etc.

- Package: `oop.structuraldesignpatterns.homeworkCache.cacheImpl.proxy`
- Class: `CacheProxy`

### Cache Time Measure Decorator
The **Cache Time Measure Decorator** measures the time taken for get operations. It extends the CacheDecorator class and can be applied to any cache implementation.

- Package: `oop.structuraldesignpatterns.homeworkCache.cacheImpl.decorator`
- Class: `CacheTimeMeasuresDecorator`

## Design Patterns Used
- **Factory Pattern**: The `CacheFactory` creates cache instances dynamically based on the cache type (e.g., FIFO).
- **Adapter Pattern**: The `LegacyCacheAdapter` adapts the legacy cache to conform to modern cache behavior and capacity management.
- **Proxy Pattern**: The `CacheProxy` adds logging functionality to any cache implementation.
- **Decorator Pattern**: The `CacheTimeMeasuresDecorator` adds time measurement functionality without altering the cache logic.

## How to Run the Tests
The Main class contains methods to test the various cache mechanisms and design patterns. 
<br>Uncomment the relevant test method in the main function to observe the behavior of different cache implementations.

### Test Methods
- `testLegacyCacheAdapter()`: Tests the legacy cache adapted for modern use.
- `testFIFOMeasureTimeCacheDecorator()`: Tests FIFO cache with time measurement.
- `testProxyFIFOCache()`: Tests FIFO cache with logging via a proxy.