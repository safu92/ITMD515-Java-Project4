/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.security.Group;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author smatches
 */
@Stateless
public class GroupService extends AbstractService<Group>{

    /**
     * constructor
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     * find all method which finds all the groups
     * @return
     */
    @Override
    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
