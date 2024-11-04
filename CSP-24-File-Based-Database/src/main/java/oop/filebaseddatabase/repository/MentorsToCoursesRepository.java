package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.MentorsToCourses;

import java.io.FileNotFoundException;
import java.util.List;

public class MentorsToCoursesRepository implements IRepository<MentorsToCourses> {
    @Override
    public List<MentorsToCourses> GetAll() {
        return List.of();
    }

    @Override
    public MentorsToCourses GetById(int id) {
        return null;
    }

    @Override
    public void Add(MentorsToCourses entity) throws FileNotFoundException {

    }

    @Override
    public void Update(MentorsToCourses entity) throws FileNotFoundException {

    }

    @Override
    public void Remove(int id) throws FileNotFoundException {

    }
}
