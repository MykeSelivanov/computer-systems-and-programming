package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.Course;

import java.io.FileNotFoundException;
import java.util.List;

public class CourseRepository implements IRepository<Course> {
    @Override
    public List<Course> GetAll() {
        return List.of();
    }

    @Override
    public Course GetById(int id) {
        return null;
    }

    @Override
    public void Add(Course entity) throws FileNotFoundException {

    }

    @Override
    public void Update(Course entity) throws FileNotFoundException {

    }

    @Override
    public void Remove(int id) throws FileNotFoundException {

    }
}
