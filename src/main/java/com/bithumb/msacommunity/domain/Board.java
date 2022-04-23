package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Date;

@Table(value = "community")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {
    @Id
    private Integer id;

    private String title;

    private String content;

    private Integer visibleYn;

    private String memberId;

    private Date insertDt;

    private Date updateDt;
}
