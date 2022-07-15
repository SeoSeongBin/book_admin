package com.greenart.book_admin.api;

import java.beans.Transient;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.data.request.BookAddRequest;
import com.greenart.book_admin.data.request.BookDescRequest;
import com.greenart.book_admin.mapper.BookMapper;

@RestController
@RequestMapping("/api/book")
public class BookAPIController {
    @Autowired BookMapper book_mapper;

    @PutMapping("/add")
    @Transactional
    public Map<String, Object> addBookInfo(@RequestBody BookAddRequest data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        BookInfoVO book_info = data.getBook_info();
        book_mapper.insertBookInfo(book_info);
        book_mapper.insertBookImg(data.getBook_img(), book_info.getBi_seq());

        for(BookDescRequest vo : data.getBook_summary()) {
            if(vo.getType().equals("text")) {
                book_mapper.insertSummary(book_info.getBi_seq(), vo.getContent());
            }
        }

        m.put("status", true);
        m.put("message", "추가하였습니다.");

        return m;
    }
}
