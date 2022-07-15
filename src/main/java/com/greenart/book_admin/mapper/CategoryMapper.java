package com.greenart.book_admin.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.CategoryInfoVO;

@Mapper
public interface CategoryMapper {
    public void insertCategory(String name) throws SQLException;
    public List<CategoryInfoVO> getCategoryList(Integer offset, String keyword);
    public Integer getCatePageCount();
    public CategoryInfoVO getCategoryBySeq(Integer seq);
    public void deletCategory(Integer seq);
    public void updateCategory(Integer seq, String name);
}
