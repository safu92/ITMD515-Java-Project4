/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author spyrisos
 */
@Stateless
public class StudentService {

    @PersistenceContext(unitName = "smatchesPU")
    private EntityManager em;

    public StudentService() {
    }

    public void create(Student s) {
        em.persist(s);
    }

    public void update(Student s) {
        em.merge(s);
    }

    public void remove(Student s) {
        em.remove(s);
    }

    public Student find(long id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll",
                Student.class).getResultList();
    }

    public Student findByUsername(String userName) {
        return em.createNamedQuery("Student.findByUsername",
                Student.class)
                .setParameter("username", userName)
                .getSingleResult();
    }

}
