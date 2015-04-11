/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Job.findByName", query = "select j from Job j where j.name = :name"),
    @NamedQuery(name = "Job.findById", query = "select j from Job j where j.id = :id"),
    @NamedQuery(name = "Job.findAll", query = "select j from Job j")})
public class Job extends BaseEntity implements Serializable {

    public Job() {
    }
    
       @OneToOne(mappedBy = "student")
        private Student student;
    
    private String jobArea;

    public Job(Student student, String jobArea) {
        this.student = student;
        this.jobArea = jobArea;
    }

    
    
    /**
     * Get the value of jobArea
     *
     * @return the value of jobArea
     */
    public String getJobArea() {
        return jobArea;
    }

    /**
     * Set the value of jobArea
     *
     * @param jobArea new value of jobArea
     */
    public void setJobArea(String jobArea) {
        this.jobArea = jobArea;
    }

}
