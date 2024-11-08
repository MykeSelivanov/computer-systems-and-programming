package oop.filebaseddatabase.repository;

import oop.filebaseddatabase.entities.*;

import java.io.Serializable;
import java.util.*;

public class DbSet implements Serializable {
    private Map<Integer,Academy> academies;
    private Map<Integer,Mentor> mentors;
    private Map<Integer,Course> courses;
    private Map<Integer,Group> groups;
    private Map<Integer,MentorsToCourses> mentorsToCourses;

    // secondary indexes - non-clustered indexes
    // academyId is non clustered index, and in set we store indices of groups
    private Map<Integer, Set<Integer>> academyGroupAcademyIndex;

    public DbSet() {
        this.academies = new HashMap<>();
        this.mentors = new HashMap<>();
        this.courses = new HashMap<>();
        this.groups = new HashMap<>();
        this.mentorsToCourses = new HashMap<>();
        this.academyGroupAcademyIndex = new TreeMap<>();
    }

    // to not lose ownership on private lists we send a copy of the lists
    public Map<Integer,Academy> getAcademies() {
        return new HashMap<>(academies);
    }

    public void setAcademies(Map<Integer,Academy> academies) {
        this.academies = academies;
    }

    public Map<Integer,Mentor> getMentors() {
        return new HashMap<>(mentors);
    }

    public void setMentors(Map<Integer,Mentor> mentors) {
        this.mentors = mentors;
    }

    public Map<Integer,Course> getCourses() {
        return new HashMap<>(courses);
    }

    public void setCoursesMap(Map<Integer,Course> courses) {
        this.courses = courses;
    }

    public Map<Integer,Group> getGroups() {
        return new HashMap<>(groups);
    }

    public void setGroupsMap(Map<Integer,Group> groups) {
        this.groups = groups;
    }

    public Map<Integer,MentorsToCourses> getMentorsToCourses() {
        return new HashMap<>(mentorsToCourses);
    }

    public void setMentorsToCoursesMap(Map<Integer,MentorsToCourses> mentorsToCourses) {
        this.mentorsToCourses = mentorsToCourses;
    }

    public void addAcademy(Academy newAcademy) {
        academies.put(newAcademy.getId(), newAcademy);
    }

    public Academy getAcademy(int id) {
        return academies.get(id);
    }

    public void addAGroup(Group newGroup) {
        groups.put(newGroup.getId(), newGroup);
        Set<Integer> academyGroupIds = academyGroupAcademyIndex.getOrDefault(newGroup.getAcademyId(), new HashSet<>());
        academyGroupIds.add(newGroup.getId());
        academyGroupAcademyIndex.put(newGroup.getAcademyId(), academyGroupIds);
    }

    // SELECT groupName FROM Group WHERE AcademyId=1
    public List<Group> getGroupsByAcademyId(int academyId) {
        List<Group> groupsByAcademyId = new ArrayList<>();
        Set<Integer> academyGroupsIds = academyGroupAcademyIndex.get(academyId);
        if (academyGroupsIds != null) {
            for (int academyGroupId: academyGroupsIds) {
                groupsByAcademyId.add(this.groups.get(academyGroupId));
            }
        }
        return groupsByAcademyId;
    }
}
