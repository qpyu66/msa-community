package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Table
@ToString
public class Comment {

    String comment_id;
    String board_id;
    String member_id;
    String comment_content;
    int comment_show_yn;
    Date insert_dt;
    Date update_dt;

}