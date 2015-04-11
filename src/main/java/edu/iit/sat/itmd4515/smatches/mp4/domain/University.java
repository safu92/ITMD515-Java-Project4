/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "University.findByName", query = "select u from University u where u.name = :name"),
    @NamedQuery(name = "University.findById", query = "select u from University u where u.id = :id"),
    @NamedQuery(name = "University.findAll", query = "select u from University u")})
public class University extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();
    
    @OneToMany(mappedBy = "university")
    private List<Professor> professors = new ArrayList<>();

    public University(String state, String name) {
        this.state = state;
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }
    
    public University() {
    }
    
    private String state;

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
        this.state = state;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
}
