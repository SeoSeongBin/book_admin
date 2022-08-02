package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.CommentReportVO;
import com.greenart.book_admin.data.UserInfoVO;
import com.greenart.book_admin.mapper.CommentMapper;

@RestController
@RequestMapping("/api/comment")
public class CommentAPIController {
    @Autowired CommentMapper com_mapper;

    @DeleteMapping("/delete")
    public Map<String, Object> deleteReport(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        com_mapper.deleteReport(seq);
        m.put("status", true);
        m.put("msg", "삭제되었습니다.");
        return m;
    }

    @GetMapping("/report_info")
    public CommentReportVO getReportInfo(@RequestParam Integer seq) {
        return com_mapper.selectReportInfo(seq);
    }

    @PatchMapping("/judge")
    public Map<String, Object> patchUserStatus(@RequestBody UserInfoVO data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        com_mapper.updateUserStatus(data);
        m.put("satatus", true);
        m.put("msg", "수정하였습니다.");
        return m;
    }
}
