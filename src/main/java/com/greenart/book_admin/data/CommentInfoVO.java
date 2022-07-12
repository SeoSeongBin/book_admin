package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class CommentInfoVO {
    private Integer cmi_seq;
    private Integer cmi_ui_seq;
    private Integer cmi_bi_seq;
    private String cmi_summary;
    private Integer cmi_score;
    private Date cmi_reg_dt;
    private Date cmi_mod_dt;
}
