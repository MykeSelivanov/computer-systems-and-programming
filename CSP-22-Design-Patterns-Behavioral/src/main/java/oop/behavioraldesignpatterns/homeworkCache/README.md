# Command-based Homework Cache System

This repository demonstrates the use of a **command pattern** for managing cache operations. The system is built around a FIFO cache implementation and allows undo/redo functionality for cache actions like `put` and `remove`.

## Table of Contents

- [Overview](#overview)
- [Cache Implementation](#cache-implementation)
    - [FIFO Cache](#fifo-cache)
- [Commands](#commands)
    - [Put Command](#put-command)
    - [Remove Command](#remove-command)
    - [Command Manager](#command-manager)
- [Design Patterns Used](#design-patterns-used)
- [How to Run the Tests](#how-to-run-the-tests)


## Overview

The Command-based Homework Cache System allows for a cache to be manipulated through commands, with the ability to undo and redo operations. The cache system uses the FIFO (First-In-First-Out) eviction policy. The commands include actions such as adding (`put`) and removing (`remove`) cache entries, with the ability to undo and redo these actions.

## Cache Implementation

### FIFO Cache

The **FIFO (First-In-First-Out)** cache evicts the oldest entry when the cache exceeds its capacity. It uses a queue to maintain the order of entries and provides basic cache functionalities.

- **Package**: `oop.behavioraldesignpatterns.homeworkCache.cacheImpl`
- **Class**: `FIFOCache`
- **Capacity management**: Oldest entry is removed when the cache is full.

## Commands
The cache operations (put, remove) are executed through commands, allowing undo/redo functionality.

### Put Command
The **PutCommand** allows adding a key-value pair to the cache. It also keeps track of the previous value for undo purposes.

- Package: `oop.behavioraldesignpatterns.homeworkCache.commands`
- Class: `PutCommand`

### Remove Command
The **RemoveCommand** removes an entry from the cache and saves the removed value to allow undoing the operation.

- Package: `oop.behavioraldesignpatterns.homeworkCache.commands`
- Class: `RemoveCommand`

### Command Manager
The **CommandManager** handles executing, undoing, and redoing commands. It stores the history of commands for managing undo and redo actions.

- Package: `oop.behavioraldesignpatterns.homeworkCache.commands`
- Class: `CommandManager`

## Design Patterns Used
- **Command Pattern**: Used to encapsulate cache operations (`put`, `remove`) as commands. Each command can be executed, undone, and redone.
- **FIFO Eviction Policy**: The cache uses a `FIFO (First-In-First-Out)` policy to manage capacity. When full, it removes the oldest cache entry.

## How to Run the Tests
The Main class contains logic to test the various cache mechanisms and design patterns.
