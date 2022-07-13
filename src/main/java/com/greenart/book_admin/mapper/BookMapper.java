package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.BookInfoVO;

@Mapper
public interface BookMapper {
    public List<BookInfoVO> getBookList(Integer offset, String keyword);
}
