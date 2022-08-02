package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.CommentReportVO;
import com.greenart.book_admin.data.UserInfoVO;

@Mapper
public interface CommentMapper {
    public List<CommentReportVO> selectListReport(Integer offset, String keyword);
    public Integer selectListReportByseq(String keyword);
    public void deleteReport(Integer seq);
    public CommentReportVO selectReportInfo(Integer seq);
    public void updateUserStatus(UserInfoVO data);
}
