package com.fanr.server.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"/","/admin"}, method = RequestMethod.GET)
    public String homepage(Model model){
        return "index";
    }


}
