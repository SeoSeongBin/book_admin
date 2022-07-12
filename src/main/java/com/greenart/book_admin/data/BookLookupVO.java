package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class BookLookupVO {
    private Integer bl_seq;
    private Integer bl_ui_seq;
    private Integer bl_bi_seq;
    private Date bl_reg_dt;
}
