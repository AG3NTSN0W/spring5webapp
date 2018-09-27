package com.example.spring5webapp.controllers;

import com.example.spring5webapp.repositories.AuthorReposity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorReposity authorReposity;

    public AuthorController(AuthorReposity authorReposity) {
        this.authorReposity = authorReposity;
    }

    @RequestMapping("/author")
    public String getAuthor(Model model){

        model.addAttribute("author", authorReposity.findAll());

        return "author";
    }
}
