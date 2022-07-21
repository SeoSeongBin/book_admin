package com.greenart.book_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.mapper.BookMapper;
import com.greenart.book_admin.mapper.CategoryMapper;
import com.greenart.book_admin.mapper.LibraryMapper;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired BookMapper book_mapper;
    @Autowired CategoryMapper cate_mapper;
    @Autowired LibraryMapper li_mapper;
    @GetMapping("/book_info")
    public String getBookInfo(Model model, @RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword) {
        if(page==null) page=1;
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", book_mapper.getBookList((page-1)*10, keyword));
        model.addAttribute("cateList", cate_mapper.getCategoryList(null, keyword));
        model.addAttribute("liList", li_mapper.getLibraryInfo(keyword, (page-1)));
        model.addAttribute("pageCnt", book_mapper.getBookInfo(keyword));
        return "/book/book_info";
    }
}
