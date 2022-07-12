package com.greenart.book_admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibraryMapper {
    public void insertLibrary(String name, String file);
}
