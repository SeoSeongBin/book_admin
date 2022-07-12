package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfoVO {
    private Integer ui_seq;
    private String ui_id;
    private String ui_pwd;
    private String ui_name;
    private String ui_nickname;
    private Date ui_bir_dt;
    private Integer ui_gen;
    private Date ui_reg_dt;
    private Integer ui_status;
}
