package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Table(value = "board")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {
    @Id
    private Integer id;

    private String title;

    private String content;

    private int visibleyn;

    private String memberid;

    @CreatedDate
    private LocalDateTime insertdt;

    @LastModifiedDate
    private LocalDateTime updatedt;
}
