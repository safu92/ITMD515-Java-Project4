/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp4.web;

import edu.iit.sat.itmd4515.smatches.mp4.domain.Course;
import edu.iit.sat.itmd4515.smatches.mp4.domain.Student;
import edu.iit.sat.itmd4515.smatches.mp4.service.CourseService;
import edu.iit.sat.itmd4515.smatches.mp4.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author smatches
 */
@WebServlet(name = "StudentPortalTestServlet", urlPatterns = {"/studentPortal", "/studentPortal/"})
public class StudentPortalTestServlet extends HttpServlet {

    @EJB
    private StudentService studentService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get all the details of student and print them
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentPortalTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentPortalTestServlet at " + request.getContextPath() + "</h1>");

            out.println("<h2>" + request.getRemoteUser() + "</h2>");

            if (request.isUserInRole("student")) {
                Student s = studentService.findByUsername(request.getRemoteUser());
                out.println("<ul>");
                out.println("<li>Name: "  + s.getFirstName() + " " + s.getLastName() + "</li>");
                out.println("<li>Birth Date: " + s.getBirthDate() + "</li>");
                out.println("<li>University: " + s.getUniversity().getName() + "</li>");
                out.println("<li><a href='"+ request.getContextPath() +"/coursePortal'>My Courses</a></li>");
                out.println("</ul>");
          }

            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
