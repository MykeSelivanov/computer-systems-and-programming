package oop.behavioraldesignpatterns.homeworkCache;

import oop.behavioraldesignpatterns.homeworkCache.cacheImpl.FIFOCache;
import oop.behavioraldesignpatterns.homeworkCache.commands.CommandManager;
import oop.behavioraldesignpatterns.homeworkCache.commands.PutCommand;
import oop.behavioraldesignpatterns.homeworkCache.commands.RemoveCommand;
import oop.behavioraldesignpatterns.homeworkCache.interfaces.ICache;

public class Main {
    public static void main(String[] args) {
        ICache<String, Integer> fifoCache = new FIFOCache<>(3);
        CommandManager<String, Integer> cacheCommandManager = new CommandManager<>();

        // execute commands to put entries
        cacheCommandManager.executeCommand(new PutCommand<>(fifoCache, "Entry 1", 123));
        cacheCommandManager.executeCommand(new PutCommand<>(fifoCache, "Entry 2", 456));
        cacheCommandManager.executeCommand(new PutCommand<>(fifoCache, "Entry 3", 789));
        cacheCommandManager.executeCommand(new PutCommand<>(fifoCache, "Entry 4", 1011));

        System.out.println(fifoCache.get("Entry 1")); // null
        System.out.println(fifoCache.get("Entry 4")); // 1011
        System.out.println(fifoCache.get("Entry 2")); // 456

        cacheCommandManager.executeCommand(new RemoveCommand<>(fifoCache, "Entry 2"));
        System.out.println(fifoCache.get("Entry 2")); // Getting the value for Entry 2 - ERROR: Key Entry 2 is not in cache. // null

        // undo the remove operation
        cacheCommandManager.undo();
        System.out.println(fifoCache.get("Entry 2")); // 456
    }
}
