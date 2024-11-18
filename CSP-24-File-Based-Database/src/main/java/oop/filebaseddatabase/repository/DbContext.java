package oop.filebaseddatabase.repository;

import java.io.*;

public class DbContext {
    private final String FILENAME;
    private boolean containsNewChanges; // it should be from global resourse file if many people use it
    private DbSet currentDbSet;

    public DbContext(String filename){
        FILENAME = "/Users/mykhailoselivanov/Documents/growthhungry/computer-systems-and-programming-projects/computer-systems-and-programming/CSP-24-File-Based-Database/src/main/java/oop/filebaseddatabase/" + filename;
        FileUtil.createFileIfNew(FILENAME);
        containsNewChanges = true;
    }

    public DbSet GetDatabase() {
        if (containsNewChanges) {
            currentDbSet = new DbSet();
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME))){
                currentDbSet = (DbSet) objectInputStream.readObject();
            } catch (EOFException e) {

            }
            catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            containsNewChanges = false;
        }

        return currentDbSet;
    }

    public void SaveChanges(DbSet database) {
        containsNewChanges = true;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            objectOutputStream.writeObject(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
