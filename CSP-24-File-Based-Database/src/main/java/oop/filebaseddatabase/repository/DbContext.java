package oop.filebaseddatabase.repository;

import java.io.*;

public class DbContext {
    private final String FILENAME;
    private boolean containsNewChanges; // it should be from the global resource file for the cases, where many clients are interacting
    private DbSet currentDbSet;

    public DbContext(String FILENAME) {
        this.FILENAME = FILENAME;
        createFileIfNew();
        this.containsNewChanges = true;
    }

    public DbSet GetDatabaseFromFile() {
        if (containsNewChanges) {
            currentDbSet = new DbSet();

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
                currentDbSet = (DbSet) objectInputStream.readObject();
            } catch (EOFException e) {

            } catch (Exception e) {
                e.printStackTrace();
            }
            containsNewChanges = false;
            return currentDbSet;
        }
        return currentDbSet;
    }

    public void SaveChangesToFile(DbSet dbSet) {
        containsNewChanges = true;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            objectOutputStream.writeObject(dbSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void createFileIfNew() {
        File file = new File(FILENAME);
        try {
            if (file.exists()) {
                System.out.println(FILENAME + " is exist");
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
