package com.springboot.User.Controller;

import com.springboot.User.dto.UserRegistrationDto;
import com.springboot.User.entity.User;
import com.springboot.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
    	User user=new User();
    	model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/showFormForUpdate/{email}")
    public String showUpdateForm(@PathVariable ( value = "email") String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user",user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/update?success";
    }
}
