package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()){
            modelAndView = new ModelAndView("index");
        }else {
            modelAndView = new ModelAndView("result");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
