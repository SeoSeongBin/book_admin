package com.greenart.book_admin.controller;

import java.lang.annotation.Repeatable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_admin.data.CommentReportVO;
import com.greenart.book_admin.mapper.CommentMapper;

@Controller
@RequestMapping("/report")
public class CommentController {
    @Autowired CommentMapper comment_mapper;
    @GetMapping("/report_info") 
    public String getReportInfo(@RequestParam @Nullable Integer page, @RequestParam @Nullable String keyword, Model model) {
        if(page == null) page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", comment_mapper.selectListReport((page-1)*10, keyword));
        model.addAttribute("pageCnt", comment_mapper.selectListReportByseq(keyword));
        return "/report/report_info";
    }
}
