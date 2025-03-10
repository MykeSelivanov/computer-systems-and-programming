package oop.filebaseddatabase.entities;

import java.io.Serializable;

public class Course implements Serializable {
    private String id;
    private String name;
    private String academyId;

    public Course(String name, String academyId) {
        this.name = name;
        this.academyId = academyId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getAcademyId() {
        return academyId;
    }
    public void setAcademyId(String academyId) {
        this.academyId=academyId;
    }

    @Override
    public String toString() {
        return getId() + " " + getName();
    }
}