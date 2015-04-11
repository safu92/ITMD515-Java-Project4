/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.service;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Meetup;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author spyrisos
 */
@Stateless
public class MeetupService extends AbstractService<Meetup> {

    public MeetupService() {
        super(Meetup.class);
    }

    @Override
    public List<Meetup> findAll() {
        return getEntityManager().createNamedQuery("Meetup.findAll").getResultList();
    }

}
