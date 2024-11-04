package oop.filebaseddatabase.repository;

import java.io.FileNotFoundException;
import java.util.List;

public interface IRepository <T> {
    List<T> GetAll();
    T GetById(int id);
    void Add(T entity) throws FileNotFoundException;
    void Update(T entity) throws FileNotFoundException;
    void Remove(int id) throws FileNotFoundException;
}
