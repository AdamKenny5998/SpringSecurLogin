/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecurity.controller;

import com.mycompany.springsecurity.exceptions.ForbiddenException;
import com.mycompany.springsecurity.model.AgentService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adam
 */
@Controller
@RequestMapping("/agents")
@SessionAttributes("agents")
public class AgentControler {

    @Autowired
    AgentService service;

    @RequestMapping("")
    public ModelAndView getAgents(HttpSession sess) {
            sess.setAttribute("uname", getLoggedInUserName());
            return new ModelAndView("/allAgents", "agentList", service.getAllAgents());

    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
}
