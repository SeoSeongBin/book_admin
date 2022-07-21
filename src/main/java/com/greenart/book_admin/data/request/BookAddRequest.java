package com.greenart.book_admin.data.request;

import java.util.List;

import com.greenart.book_admin.data.BookImgVO;
import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.data.SummaryInfoVO;

import lombok.Data;

@Data
public class BookAddRequest {
    private BookInfoVO book_info;
    private BookImgVO book_img;
    private SummaryInfoVO book_summary;
}
