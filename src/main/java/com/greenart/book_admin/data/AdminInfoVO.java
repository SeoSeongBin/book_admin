package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class AdminInfoVO {
    private Integer ai_seq;
    private String ai_id;
    private String ai_pwd;
    private Integer ai_status;
    private String ai_name;
    private Date ai_reg_dt;
    private String ai_profile_file;
}
