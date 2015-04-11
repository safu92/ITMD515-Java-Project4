///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.sat.itmd4515.sspyriso.mp4.service;
//
//import edu.iit.sat.itmd4515.smatches.mp4.domain.Course;
//import edu.iit.sat.itmd4515.sspyriso.mp4.domain.DiscJockey;
//import edu.iit.sat.itmd4515.sspyriso.mp4.domain.Listener;
//import edu.iit.sat.itmd4515.sspyriso.mp4.domain.RadioStation;
//import edu.iit.sat.itmd4515.smatches.mp4.domain.security.Group;
//import edu.iit.sat.itmd4515.smatches.mp4.domain.security.User;
//import java.util.GregorianCalendar;
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//
///**
// *
// * @author spyrisos
// */
//@Singleton
//@Startup
//public class DatabasePopulator {
//
//    @EJB
//    private RadioStationService stationService;
//
//    @EJB
//    private UserService userService;
//
//    @EJB
//    private GroupService groupService;
//
//    @EJB
//    private ListenerService listenerService;
//    
//    @EJB
//    private DJService djService;
//    
//    public DatabasePopulator() {
//    }
//
//    @PostConstruct
//    private void seedDatabase() {
//
//        Group student = new Group("STUDENT", "Students Group");
//        Group professor = new Group("Professor", "Professors Group");
//
//        User safu = new User("safu", "abc123");
//        User test = new User("test", "test");
//        User matches = new User("matches", "abc123");
//        test.addGroup(student);
//        safu.addGroup(professor);
//        matches.addGroup(professor);
//        
//        Course c1 = new Course(safu, "Advanced Software Development", "Fall 2014", "ITMD515");
//        //Course c2 = new Course("WNUR");
//        //Course c3 = new Course("WBRZ");
//        //Course c4 = new Course("KCRW");
//
//        Listener l1 = new Listener(Boolean.FALSE,
//                new GregorianCalendar(1970, 0, 12).getTime(),
//                "Listener",
//                "One");
//        l1.setUser(fan);
//
//        DiscJockey dj1 = new DiscJockey("AK",
//                new GregorianCalendar(1980, 0, 12).getTime(),
//                "Akarshan",
//                "Kumar");
//        dj1.setUser(ak);
//        dj1.setRadioStation(wiit);
//        wiit.getDiscJockeys().add(dj1);
//        
//        DiscJockey dj2 = new DiscJockey("Prof",
//                new GregorianCalendar(1960, 0, 12).getTime(),
//                "Scott",
//                "Spyrison");    
//        dj2.setUser(scott);
//        dj2.setRadioStation(wnur);
//        wnur.getDiscJockeys().add(dj2);
//
//        groupService.create(dj);
//        groupService.create(listener);
//        
//        stationService.create(wiit);
//        stationService.create(wnur);
//        stationService.create(wbez);
//        stationService.create(kcrw);
//        
//        userService.create(scott);
//        userService.create(ak);
//        userService.create(fan);
//        
//        listenerService.create(l1);
//        djService.create(dj1);
//        djService.create(dj2);
//        
//    }
//}
