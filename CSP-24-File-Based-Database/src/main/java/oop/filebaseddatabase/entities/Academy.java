package oop.filebaseddatabase.entities;

import java.io.Serializable;

public class Academy implements Serializable {
    private String id;
    private String description;

    public Academy(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id=id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public String toString() {
        return getId() + " " + getDescription();
    }
}
