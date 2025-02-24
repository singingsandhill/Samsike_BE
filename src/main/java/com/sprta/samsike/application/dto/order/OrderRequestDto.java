package com.sprta.samsike.application.dto.order;

import com.sprta.samsike.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrderRequestDto {
    private UUID restaurantId;  // 가게 ID
    private Integer orderAmount; // 총 주문 금액
    private List<OrderProductDto> products; // 주문한 상품 목록
    private String requirement; // 요청사항
    private Boolean isDisposal; // 일회용기 사용 여부

}
