package com.greenart.book_admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.mapper.AdminMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired AdminMapper admin_mapper;
    @GetMapping("/admin_info")
    public String getAdmininfo(Model model, @RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword) {
        if(page==null) page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", admin_mapper.getAdminList(keyword, (page-1)*10));
        model.addAttribute("pageCnt", admin_mapper.getAdminAccount(keyword));
        return "/admin/admin_info";
    }
    @GetMapping("/admin_form")
    public String getAdminAdd() {

        return "/admin/admin_form";
    }
    @GetMapping("/logout")
    public String getAccountLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
