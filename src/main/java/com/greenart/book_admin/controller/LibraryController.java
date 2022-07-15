package com.greenart.book_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.mapper.LibraryMapper;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired LibraryMapper li_mapper;
    @GetMapping("/library_info")
    public String getLibraryInfo(Model model, @RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword) {
        
        if(page==null) page=1;
        
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", li_mapper.getLibraryInfo(keyword, (page-1)*8));
        model.addAttribute("pageCnt", li_mapper.getLibraryCount(keyword));
        return "/library/library_info";
    } 
}
