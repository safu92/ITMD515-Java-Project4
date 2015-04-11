/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import edu.iit.sat.itmd4515.smatches.mp4.domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Student.findByName", query = "select s from Student s where s.lastName = :lname"),
    @NamedQuery(name = "Student.findById", query = "select s from Student s where s.id = :id"),
    @NamedQuery(name = "Student.findAll", query = "select s from Student s"),
    @NamedQuery(name = "Student.findByUsername", query = "select s from Student s where s.user.userName = :username")})
public class Student extends Person implements Serializable {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
    
    
     @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
     
      @ManyToMany
    @JoinTable(name = "student_meetup",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "meetup_id"))
    private List<Meetup> meetups = new ArrayList<>();
    
    @OneToOne(mappedBy = "student")
    private Job job;
     
     public Student() {
    }
    
    private String major;

    public List<Course> getCourses() {
        return courses;
    }

    
    
    public Student(University university, String major, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.university = university;
        this.major = major;
    }

    public List<Meetup> getMeetups() {
        return meetups;
    }

    public Job getJob() {
        return job;
    }

    
    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    
    /**
     * Get the value of major
     *
     * @return the value of major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set the value of major
     *
     * @param major new value of major
     */
    public void setMajor(String major) {
        this.major = major;
    }
    
    
}
