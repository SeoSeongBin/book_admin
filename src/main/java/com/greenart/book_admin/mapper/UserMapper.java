package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.UserInfoVO;

@Mapper
public interface UserMapper {
    public List<UserInfoVO> getUserList(Integer offset, String keyword);
    public Integer getUserCnt(String keyword);
    public UserInfoVO getUserBySeq(Integer seq);
    public void updateUser(UserInfoVO data);
    public void deleteUser(Integer seq);
}
