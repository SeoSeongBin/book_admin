package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class CommentReportVO {
    private Integer cr_seq;
    private Integer cr_ui_seq;
    private Integer cr_ci_seq;
    private Date cr_reg_dt;
    private Integer cr_reason;
}
