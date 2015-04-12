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
    @NamedQuery(name = "Professor.findByName", query = "select p from Professor p where p.lastName = :lname"),
    @NamedQuery(name = "Professor.findById", query = "select p from Professor p where p.id = :id"),
    @NamedQuery(name = "Professor.findAll", query = "select p from Professor p")})
public class Professor extends Person implements Serializable {

      @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
    
     @ManyToMany
    @JoinTable(name = "professor_course",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
    
    
    @OneToOne
    private Meetup meetup;
    
    
    public Professor() {
    }

    public Meetup getMeetup() {
        return meetup;
    }

    public void setMeetup(Meetup meetup) {
        this.meetup = meetup;
    }

    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    public Professor(University university,Meetup meetup, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.university = university;
        this.meetup = meetup;
    }
    
    
   
    

    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Professor(Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
    }

    
    
    

   
}
