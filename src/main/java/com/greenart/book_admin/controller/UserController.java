package com.greenart.book_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.mapper.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserMapper user_mapper;
    @GetMapping("/user_info")
    public String getUserInfo(Model model, @RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword) {
        if(page==null) page = 1;
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", user_mapper.getUserList((page-1)*10, keyword));
        model.addAttribute("pageCnt", user_mapper.getUserCnt(keyword));
        return "/user/user_info";
    }
}
