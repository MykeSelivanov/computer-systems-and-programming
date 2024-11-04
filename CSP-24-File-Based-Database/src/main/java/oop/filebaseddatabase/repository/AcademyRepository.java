package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.Academy;

import java.io.FileNotFoundException;
import java.util.List;

public class AcademyRepository implements IRepository<Academy> {
    private DbContext dbContext;

    public AcademyRepository(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    @Override
    public List<Academy> GetAll() {
        DbSet dbSet = dbContext.GetDatabaseFromFile();
        return dbSet.getAcademies();
    }

    @Override
    public Academy GetById(int id) {
        List<Academy> academies = GetAll();
        for (Academy academy : academies) {
            if (academy.getId() == id) {
                return academy;
            }
        }
        return null;
    }

    @Override
    public void Add(Academy academyToAdd) throws FileNotFoundException {
        List<Academy> academies = GetAll();
        academies.add(academyToAdd);
        SaveChanges(academies);
    }

    @Override
    public void Update(Academy academyToUpdate) throws FileNotFoundException {
        List<Academy> academies = GetAll();
        for (int i = 0; i < academies.size(); i++) {
            if (academies.get(i).getId() == academyToUpdate.getId()) {
                academies.set(i, academyToUpdate);
                break;
            }
        }
        SaveChanges(academies);
    }

    @Override
    public void Remove(int id) throws FileNotFoundException {
        List<Academy> academies = GetAll();
        academies.removeIf(academy -> academy.getId() == id);
        SaveChanges(academies);
    }

    private void SaveChanges(List<Academy> academies) throws FileNotFoundException {
        DbSet dbSet = dbContext.GetDatabaseFromFile();
        dbSet.setAcademies(academies);
        dbContext.SaveChangesToFile(dbSet);
    }
}
