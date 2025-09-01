package com.example.Day12_Form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Day12_Form.forms.UserForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller()
@RequestMapping("/form")
public class UserController {

    @GetMapping("")
    public String form(Model model) {
        UserForm attributeValue = new UserForm();
        model.addAttribute("userForm", attributeValue);
        return "form";
    }
    
    
    @PostMapping()
    public String submit(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        
        //model.addAttribute("name", userForm.getName());
        model.addAttribute("user", userForm);
        return "greeting";
    }
    
}
