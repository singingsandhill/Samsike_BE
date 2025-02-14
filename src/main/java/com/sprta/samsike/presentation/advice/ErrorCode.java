package com.sprta.samsike.presentation.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // member
    MEMB001("MEBE001","일치하는 아이디 없음"),
    MEMB002("MEBE002","로그인 정보 불일치"),

    // restaurant
    REST001("REST001",""),

    //category
    CATE001("CATE001",""),


    //UNKNOWN_ERROR
    UNKNOWN_ERROR("UNKNOWN_ERROR","예외 처리 하지 않은 에러")


    ;

    private final String code;
    private final String message;
}
