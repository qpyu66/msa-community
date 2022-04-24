package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Table(value = "reply")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
    @Id
    private Integer replyid;

    private Integer boardid;

    private Integer memberid;

    private String replycontent;

    private Integer replyvisibleyn;

    @CreatedDate
    private LocalDateTime insertdt;

    @LastModifiedDate
    private LocalDateTime updatedt;

}