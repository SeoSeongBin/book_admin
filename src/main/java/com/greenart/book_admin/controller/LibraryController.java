package com.greenart.book_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @GetMapping("/library_info")
    public String getLibraryInfo(Model model) {
        
        return "/library/library_info";
    } 
}
