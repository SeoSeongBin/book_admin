package com.greenart.book_admin.data;

import java.util.Date;

import lombok.Data;

@Data
public class BookInfoVO {
    private Integer bi_seq;
    private Integer bi_li_seq;
    private Integer bi_ci_seq;
    private String bi_name;
    private String bi_author;
    private String bi_publisher;
    private Date bi_publication_dt;
    private Integer bi_status;
    private Date bi_reg_dt;

    private String bi_img;
    private String ci_name;
    private String si_summary;
}
