package com.booklibrary.booklibrary.controller;


import com.booklibrary.booklibrary.entity.User;
import com.booklibrary.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/new")
    public String signup(Model model){
        User customer = new User();

        model.addAttribute("customer", customer);
        return "signup";
    }

    @PostMapping("/save")
    public String saveCustomer(User customer, RedirectAttributes ra){

       repository.save(customer);
        ra.addFlashAttribute("message", "The customer has been saved successfully.");
        return "redirect:/user/login";
    }
    @GetMapping("/book")
    public String book(){
        return "Book";
    }

   // public String
}
