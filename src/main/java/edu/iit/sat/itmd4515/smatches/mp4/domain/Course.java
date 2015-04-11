/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
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
    @NamedQuery(name = "Course.findById", query = "select c from Course c where c.id = :id"),
    @NamedQuery(name = "Course.findByName", query = "select c from Course c where c.name = :name"),
    @NamedQuery(name = "Course.findAll", query = "select c from Course c")})
public class Course extends BaseEntity implements Serializable {

    public Course() {
    }
    
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();
    
       @OneToOne(mappedBy = "course")
        private Professor professor;
    
        private String courseName;

    public Professor getProfessor() {
        return professor;
    }

    
        
        

    public List<Student> getStudents() {
        return students;
    }

        
    /**
     * Get the value of courseName
     *
     * @return the value of courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the value of courseName
     *
     * @param courseName new value of courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private String courseTerm;

    /**
     * Get the value of courseTerm
     *
     * @return the value of courseTerm
     */
    public String getCourseTerm() {
        return courseTerm;
    }

    /**
     * Set the value of courseTerm
     *
     * @param courseTerm new value of courseTerm
     */
    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    private String courseId;

    /**
     * Get the value of courseId
     *
     * @return the value of courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Set the value of courseId
     *
     * @param courseId new value of courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Course(Professor professor, String courseName, String courseTerm, String courseId) {
        this.professor = professor;
        this.courseName = courseName;
        this.courseTerm = courseTerm;
        this.courseId = courseId;
    }

    
}
