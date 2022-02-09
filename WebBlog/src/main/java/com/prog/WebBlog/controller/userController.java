package com.prog.WebBlog.controller;

import com.prog.WebBlog.models.UserM;
import com.prog.WebBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class userController {
    private final UserService userService;
    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("user", new UserM());
        return "Login";
    }
    @PostMapping("/login")
    public String saveUser(@ModelAttribute UserM userM){
    UserM registeredUser = userService.registerUser(userM.getLogin(),userM.getEmail(),userM.getPassword());

    return registeredUser == null ? "Error_page" : "SingIn";
    }

    @GetMapping("/SingIn")
    public String SingIn(Model model){
        model.addAttribute("singIn", new UserM());
        return "SingIn";
    }
    @PostMapping("/SingIn")
    public String singIn(@ModelAttribute UserM userM, Model model){
        UserM authenticated = userService.authenticate(userM.getEmail(),userM.getPassword());
        if (authenticated != null){
            model.addAttribute("userEmail", authenticated.getEmail());
            return "MyProfile";
        }else {
            return "Login";
        }
    }

}
