package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.LibraryInfoVO;
import com.greenart.book_admin.mapper.LibraryMapper;

@RestController
@RequestMapping("/api/library")
public class LibraryAPIController {
    @Autowired LibraryMapper li_mapper;
    @PutMapping("/add")
    public ResponseEntity<Map<String, Object>> putLibraryInfo(@RequestBody LibraryInfoVO data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        try{
            li_mapper.insertLibrary(data);
        }
        catch(DuplicateKeyException e) {
            m.put("status", false);
            m.put("message", data.getLi_name()+"은(는) 이미 등록된 도서관입니다.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }

        m.put("status", true);
        m.put("message", "등록이 완료되었습니다.");

        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
    }

    @GetMapping("/info")
    public LibraryInfoVO getLibraryInfo(@RequestParam Integer seq) {
        return li_mapper.getLibraryInfoMod(seq);
    }

    @PatchMapping("/modify")
    public ResponseEntity<Map<String, Object>> patchLibraryinfo(@RequestBody LibraryInfoVO data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        if(data.getLi_name() == null || data.getLi_name().equals("")) {
            m.put("status", false);
            m.put("message", "도서관명 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }

        li_mapper.updateLibrary(data);
        m.put("status", true);
        m.put("message", "도서관 정보를 수정하였습니다.");
        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteLibraryInfo(@RequestParam Integer seq) {
        Map <String, Object> m = new LinkedHashMap<String, Object>();

        li_mapper.deleteLibraryInfo(seq);
        m.put("status", true);
        m.put("message", "삭제하셨습니다.");

        return m;
    }

}
