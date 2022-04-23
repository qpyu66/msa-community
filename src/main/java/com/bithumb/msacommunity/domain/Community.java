package com.bithumb.msacommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(value = "community")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Community {
    @Id
    private Integer communityId;
    private String communityTitle;
    private String communityContent;
    private Integer communityShowYN;
    private String memberId;
    private Date insertDt;
    private Date updateDt;

}
