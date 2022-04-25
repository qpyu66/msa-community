package com.bithumb.msacommunity.domain;

import lombok.Data;

@Data
public class UserDTO {
    private Integer memberId;
    private String memberType;

    public UserDTO(int memberId, String memberType) {
        this.memberId = memberId;
        this.memberType = memberType;
    }

    public UserDTO() {
    }
}
