package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.Group;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository implements IRepository<Group> {
    private DbContext dbContext;

    public GroupRepository(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    @Override
    public List<Group> GetAll() {
        DbSet dbSet = dbContext.GetDatabaseFromFile();
        return dbSet.getGroups();
    }

    @Override
    public Group GetById(int id) {
        List<Group> academyGroups = GetAll();
        for (Group academyGroup : academyGroups) {
            if (academyGroup.getId() == id) {
                return academyGroup;
            }
        }
        return null;
    }

    @Override
    public void Add(Group groupToAdd) throws FileNotFoundException {
        List<Group> groups = GetAll();
        groups.add(groupToAdd);
        SaveChanges(groups);
    }

    @Override
    public void Update(Group groupToUpdate) throws FileNotFoundException {
        List<Group> groups = GetAll();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId() == groupToUpdate.getId()) {
                groups.set(i, groupToUpdate);
                break;
            }
        }
        SaveChanges(groups);
    }

    @Override
    public void Remove(int id) throws FileNotFoundException {
        List<Group> groups = GetAll();
        groups.removeIf(group -> group.getId() == id);
        SaveChanges(groups);
    }

    private void SaveChanges(List<Group> groups) throws FileNotFoundException {
        DbSet dbSet = dbContext.GetDatabaseFromFile();
        dbSet.setGroups(groups);
        dbContext.SaveChangesToFile(dbSet);
    }
}
