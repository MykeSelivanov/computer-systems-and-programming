package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DbSet implements Serializable {
    private List<Academy> academies;
    private List<Mentor> mentors;
    private List<Course> courses;
    private List<Group> groups;
    private List<MentorsToCourses> mentorsToCourses;

    public DbSet() {
        this.academies = new ArrayList<>();
        this.mentors = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.mentorsToCourses = new ArrayList<>();
    }

    // to not lose ownership on private lists we send a copy of the lists
    public List<Academy> getAcademies() {
        return new ArrayList<>(academies);
    }

    public void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }

    public List<Mentor> getMentors() {
        return new ArrayList<>(mentors);
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<MentorsToCourses> getMentorsToCourses() {
        return new ArrayList<>(mentorsToCourses);
    }

    public void setMentorsToCourses(List<MentorsToCourses> mentorsToCourses) {
        this.mentorsToCourses = mentorsToCourses;
    }
}
