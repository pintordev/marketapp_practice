package com.pintor.marketapp.home;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/index")
    public String index() {
        return "home/index";
    }
}
