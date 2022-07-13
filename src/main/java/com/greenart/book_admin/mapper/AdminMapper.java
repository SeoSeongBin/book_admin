package com.greenart.book_admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.book_admin.data.AdminInfoVO;

@Mapper
public interface AdminMapper {
    public List<AdminInfoVO> getAdminList(String keyword, Integer offset);
    public Integer getAdminAccount(String keyword);
    public void insertAdmin(AdminInfoVO data);
    public AdminInfoVO loginAdmin(AdminInfoVO data);
    public void deleteAdmin(Integer seq);
    public AdminInfoVO selectAdminBySeq(Integer seq);
    public void updateAdmin(AdminInfoVO data);
}
