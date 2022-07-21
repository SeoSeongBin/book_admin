package com.greenart.book_admin.data.request;

import lombok.Data;

@Data
public class BookDescRequest {
    private String type;
    private String content;
    private Integer order;
}
