package com.greenart.book_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.mapper.CategoryMapper;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired CategoryMapper cate_mapper;
    @GetMapping("/category_info")
    public String getCategoryInfo(Model model, @RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword) {
        if(page == null) page = 1;
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", cate_mapper.getCategoryList((page-1)*10, keyword));
        model.addAttribute("pageCount", cate_mapper.getCatePageCount());

        return "/category/category_info";
    }
}
