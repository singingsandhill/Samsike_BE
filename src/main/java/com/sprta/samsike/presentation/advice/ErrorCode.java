package com.sprta.samsike.presentation.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // member
    MEMB001("MEBE001","일치하는 아이디 없음"),
    MEMB002("MEBE002","로그인 정보 불일치"),

    //product
    PROD001("PROD001","일치하는 가게 없음"),
    PROD002("PROD002","메뉴를 생성 할 수 없는 유저"),
    PROD003("PROD003","중복된 메뉴"),
    PROD004("PROD004","메뉴 생성 권한 없음"),
    PROD005("PROD005","일치하는 상품 없음"),

    // restaurant
    REST001("REST001","일치하는 가게 없음"),
    REST002("REST002","가게를 생성 할 수 없는 유저"),
    REST003("REST003","중복된 가게"),
    REST004("REST001","가게 생성 권한 없음"),
    REST005("REST005", "가게 삭제 불가"),

    //category
    CATE001("CATE001","카테고리 중복"),
    CATE002("CATE001","일치하는 카테고리 없음"),
    CATE003("CATE003", "카테고리 삭제 불가."),

    //ssgCode
    SSGC001("SSGC001","일치하는 지역코드 없음"),

    //ai UUID
    UUID001("UUID001","일치하는 고유번호 없음"),

    // order
    ORDER001("ORDER001", "존재하지 않는 주문입니다."),
    ORDER002("ORDER002", "관리자는 특정 가게의 주문만 조회 가능."),
    ORDER003("ORDER003", "자신의 주문만 조회할 수 있음."),
    ORDER004("ORDER004", "주문을 취소할 수 있는 시간이 초과."),
    ORDER005("ORDER005", "주문을 취소 권한이 없음."),
    ORDER006("ORDER006", "주문을 취소할 수 있는 시간이 경과."),
    ORDER007("ORDER007", "주문 요청 권한이 없음."),
    ORDER008("ORDER008", "주문자의 기본 지역 정보가 없습니다."),
    ORDER009("ORDER009", "이미 취소된 주문입니다."),

    //token
    TOKN001("TOKN001","유효하지 않은 토큰"),
    TOKN002("TOKN002","로그아웃 된 토큰"),

    // AUTH
    AUTH001("AUTH001","권한이 없습니다."),

    // REVIEW
    REVW001("REVW001","작성자가 아닙니다."),

    //UNKNOWN_ERROR
    UNKNOWN_ERROR("UNKNOWN_ERROR","예외 처리 하지 않은 에러"),

    // PAYMENT
    PAYMENT001("PAYMENT001", "결제 정보를 찾을 수 없습니다."),
    PAYMENT002("PAYMENT002", "결제 정보를 조회할 권한이 없습니다."),
    PAYMENT003("PAYMENT003", "본인의 주문이 아니라 결제할 수 없습니다."),
    PAYMENT004("PAYMENT004", "결제 정보가 존재하지 않습니다.");

    private final String code;
    private final String message;
}
