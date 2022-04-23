package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Table
@ToString
public class Board {
    Long id;
    String board_id;
    String board_title;
    String board_content;
    int board_show_yn;
    String member_id;
    Date insert_dt;
    Date update_dt;

}
