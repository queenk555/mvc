package com.queenk.mvc.controller;

import com.queenk.mvc.entity.User;
import com.queenk.mvc.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user",service.findAll());
        model.addAttribute("count",service.count());
        return "index";
    }

    @GetMapping("/user")
    public String save(User user) {
        service.save(user);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(User user) {
        return "user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws NotFoundException {
        model.addAttribute("user", service.findById(id));
        return "user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
