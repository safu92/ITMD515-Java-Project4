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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
       @OneToOne(mappedBy = "meetup")
        private Professor professor;
       
        @ManyToMany(mappedBy = "meetups", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();
       
    @Temporal(TemporalType.DATE)
    private Date date;
    
        private String place;

    /**
     * Get the value of place
     *
     * @return the value of place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Set the value of place
     *
     * @param place new value of place
     */
    public void setPlace(String place) {
        this.place = place;
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

    public Meetup(Date date, String place, String topic) {
        this.date = date;
        this.place = place;
        this.topic = topic;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    

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
    
    

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Meetup{topic=").append(topic).append('}');
        return sb.toString();
    }
    
}
