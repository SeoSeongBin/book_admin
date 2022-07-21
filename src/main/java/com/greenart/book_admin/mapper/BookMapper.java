package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.BookImgVO;
import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.data.SummaryInfoVO;
import com.greenart.book_admin.data.request.BookAddRequest;

@Mapper
public interface BookMapper {
    public List<BookInfoVO> getBookList(Integer offset, String keyword);
    public Integer getBookInfo(String keyword);
    public void insertBookInfo(BookInfoVO data);
    public void insertBookImg(Integer seq, BookImgVO data);
    public void insertSummary(Integer seq, SummaryInfoVO data);
    public void deleteBookInfo(Integer seq);
    public void deleteBookImg(Integer seq);
    public void deleteBookSummary(Integer seq);
    public BookInfoVO selectBookMod(Integer seq);
    public void updateBookInfo(BookInfoVO data);
    public void updateBookImg(Integer seq, BookImgVO data);
    public void updateBookSummary(Integer seq, SummaryInfoVO data);
}
