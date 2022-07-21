package com.greenart.book_admin.api;

import java.beans.Transient;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.BookImgVO;
import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.data.SummaryInfoVO;
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

        BookImgVO book_img = data.getBook_img();
        book_mapper.insertBookImg(book_info.getBi_seq(), book_img);

        SummaryInfoVO book_summary = data.getBook_summary();
        book_mapper.insertSummary(book_info.getBi_seq(), book_summary);

        m.put("status", true);
        m.put("message", "추가하였습니다.");

        return m;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteBookInfo(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        book_mapper.deleteBookInfo(seq);
        book_mapper.deleteBookImg(seq);
        book_mapper.deleteBookSummary(seq);

        m.put("status", true);
        m.put("message", "도서 정보가 삭제되었습니다.");

        return m;
    }

    @GetMapping("/info")
    public BookInfoVO getBookInfoMod(@RequestParam Integer seq) {
        return book_mapper.selectBookMod(seq);
    }

    @PatchMapping("/update")
    public Map<String, Object> updateBookInfo(@RequestBody BookAddRequest data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        BookInfoVO book_info = data.getBook_info();
        book_mapper.updateBookInfo(book_info);

        BookImgVO book_img = data.getBook_img();
        book_mapper.updateBookImg(book_info.getBi_seq(), book_img);

        SummaryInfoVO book_summary = data.getBook_summary();
        book_mapper.updateBookSummary(book_info.getBi_seq(), book_summary);

        m.put("status", true);
        m.put("message", "수정되었습니다.");

        return m;
    }
}
