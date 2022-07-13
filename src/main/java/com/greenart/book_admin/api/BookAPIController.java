package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.BookInfoVO;
import com.greenart.book_admin.mapper.BookMapper;

@RestController
@RequestMapping("/api/book")
public class BookAPIController {
    @Autowired BookMapper book_mapper;
    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> addBookInfo(@RequestBody BookInfoVO data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        
        if(data.getBi_name() == null || data.getBi_name().equals("")) {
            m.put("status", false);
            m.put("message", "비밀번호를 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }
        if(data.getBi_ci_seq() == null || data.getBi_ci_seq().equals("")) {
            m.put("status", false);
            m.put("message", "이름을 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
    }
}
