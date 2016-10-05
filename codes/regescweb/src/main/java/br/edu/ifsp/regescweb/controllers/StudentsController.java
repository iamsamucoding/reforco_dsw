
package br.edu.ifsp.regescweb.controllers;

import br.edu.ifsp.regescweb.dao.StudentDAO;
import br.edu.ifsp.regescweb.models.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentsController {
    
    @RequestMapping("/students")
    public ModelAndView index() {
        ModelAndView mav = null;
        
        try {
            StudentDAO dao = new StudentDAO();
            ArrayList<Student> list = dao.findAll();
            
            mav = new ModelAndView("students/index"); // /WEB-INF/views/students/index.jsp
            mav.addObject("list", list);
            
        } catch (ClassNotFoundException ex) {
            mav = new ModelAndView("students/error");
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            mav = new ModelAndView("students/error");
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mav;
    }
    
    
    @RequestMapping("/students/new")
    public String newStudent() {
        return "students/new"; // /WEB-INF/views/students/new.jsp
    }
    
    
    @RequestMapping("/students/create")
    public ModelAndView create(Student student) {
        ModelAndView mav = null;
        
        try {
            StudentDAO dao = new StudentDAO();
            dao.insert(student);
            
            mav = new ModelAndView("students/show");
            mav.addObject("student", student);
        } catch (ClassNotFoundException ex) {
            mav = new ModelAndView("students/error");
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            mav = new ModelAndView("students/error");
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mav;
    }
    
}
