package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.BookImgVO;
import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.data.SummaryInfoVO;

@Mapper
public interface BookMapper {
    public List<BookInfoVO> getBookList(Integer offset, String keyword);
    public void insertBookInfo(BookInfoVO data);
    public void insertBookImg(List<String> list, Integer seq);
    public void insertSummary(Integer seq, String content);
}
