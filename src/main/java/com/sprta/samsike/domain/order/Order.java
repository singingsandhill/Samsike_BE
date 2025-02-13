package com.sprta.samsike.domain.order;

import com.sprta.samsike.domain.member.Member;
import com.sprta.samsike.domain.region.UserRegion;
import com.sprta.samsike.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(catalog = "samsike", name = "p_order")
public class Order {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "user_region_uuid", nullable = false)
    private UserRegion userRegion;

    @ManyToOne
    @JoinColumn(name = "restaurant_uuid", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String orderType;

    @Column(nullable = false)
    private String orderStatus;

    @Column(nullable = false)
    private Integer orderAmount;

    private String requirement;

    @Column(nullable = false)
    private Boolean isDisposal;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime deletedAt;
    private String deletedBy;
}
