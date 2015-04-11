/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "Professor.findByName", query = "select p from Professor p where p.name = :name"),
    @NamedQuery(name = "Professor.findById", query = "select p from Professor p where p.id = :id"),
    @NamedQuery(name = "Professor.findAll", query = "select p from Professor p")})
public class Professor extends Person implements Serializable {

    @ManyToOne
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
    
    @OneToOne
    private Course course;
    
    @OneToOne
    private Meetup meetup;
    
    public Professor() {
    }

    public Professor(University university, Course course, Meetup meetup, Date birthDate, String firstName, String lastName) {
        super(birthDate, firstName, lastName);
        this.university = university;
        this.course = course;
        this.meetup = meetup;
    }
    
    
   
    

    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Course getCourse() {
        return course;
    }
    
    

   
}
