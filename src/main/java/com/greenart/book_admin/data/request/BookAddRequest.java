package com.greenart.book_admin.data.request;

import java.util.List;

import com.greenart.book_admin.data.BookInfoVO;

import lombok.Data;

@Data
public class BookAddRequest {
    private BookInfoVO book_info;
    private List<String> book_img;
    private List<BookDescRequest> book_summary;
}
