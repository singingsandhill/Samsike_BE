package com.sprta.samsike.domain.order;

import com.sprta.samsike.domain.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(catalog = "samsike", name = "p_order_product")
public class OrderProduct {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "order_uuid", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_uuid", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer productCnt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime deletedAt;
    private String deletedBy;
}

