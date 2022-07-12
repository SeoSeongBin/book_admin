package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.mapper.CategoryMapper;

@RestController
@RequestMapping("/api/category")
public class CategoryAPIController {
    @Autowired CategoryMapper cate_mapper;
    @PutMapping("/add")
    public Map<String, Object> putAddCategory(@RequestParam String name) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        try {
            cate_mapper.insertCategory(name);
        }catch (Exception e) {
            if(e.getCause().getMessage().indexOf("duplicate") >= 0) {
                m.put("status", false);
                m.put("message", name+"은(는) 이미 등록되어있습니다.");
                return m;
            }
        }
        m.put("status", true);
        m.put("message", "카테고리 정보를 추가하였습니다.");
        return m;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteCategory(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        cate_mapper.deletCategory(seq);
        m.put("message", "카테고리 정보가 삭제되었습니다.");
        m.put("status", true);
        return m;
    }

    @GetMapping("/name")
    public Map<String, Object> getCategoryBySeq(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("name", cate_mapper.getCategoryBySeq(seq).getCi_name());
        return m;
    }

    @PatchMapping("/modify")
    public Map<String, Object> patchCategory(@RequestParam Integer seq, @RequestParam String name) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        try {
            cate_mapper.updateCategory(seq, name);
        }catch(DuplicateKeyException e) {
            m.put("status", false);
            m.put("message", name+"은 이미등록되었습니다.");
            return m;
        }
        m.put("status", true);
        m.put("message", "카테고리 명이 변경되었습니다.");
        return m;
    }
}
