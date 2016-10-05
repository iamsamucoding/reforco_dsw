
package br.edu.ifsp.regescweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "home"; // /WEB-INF/views/home.jsp
    }
}
