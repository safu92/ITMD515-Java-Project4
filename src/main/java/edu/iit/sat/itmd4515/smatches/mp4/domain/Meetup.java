/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Meetup.findById", query = "select m from Meetup m where m.id = :id"),
    @NamedQuery(name = "Meetup.findAll", query = "select m from Meetup m")})
public class Meetup extends BaseEntity implements Serializable{

    public Meetup() {
    }
    
       @OneToOne(mappedBy = "professor")
        private Professor professor;
       
        @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();
       
    private Date date;

    public Meetup(Professor professor, Date date, String topic) {
        this.professor = professor;
        this.date = date;
        this.topic = topic;
    }

    
    
    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    private String topic;

    /**
     * Get the value of topic
     *
     * @return the value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Set the value of topic
     *
     * @param topic new value of topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    

}
