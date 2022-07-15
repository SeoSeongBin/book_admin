package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.LibraryInfoVO;

@Mapper
public interface LibraryMapper {
    public void insertLibrary(LibraryInfoVO data);
    public List<LibraryInfoVO> getLibraryInfo(String keyword, Integer offset);
    public Integer getLibraryCount(String keyword);
    public LibraryInfoVO getLibraryInfoMod(Integer seq);
    public void updateLibrary(LibraryInfoVO data);
    public void deleteLibraryInfo(Integer seq);
}
