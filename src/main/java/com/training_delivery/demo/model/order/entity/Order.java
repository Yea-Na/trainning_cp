package com.training_delivery.demo.model.order.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_order SET order_is_Deleted = true WHERE order_uuid = ?")
@SQLRestriction("order_is_deleted = false")
@Table(name = "p_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_uuid")
    private UUID orderid;

    @Column(name = "order_total_price")
    private int totalPrice;

    @Column(name = "order_total_quantity")
    private int totalQuantity;

    @Column(name = "order_order_message")
    private String OrderMessage;

    @Column(name = "order_order_type")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Column(name = "order_order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder.Default
    @Column(name = "order_is_Deleted")
    private Boolean isDeleted = Boolean.FALSE;

    @OneToMany(mappedBy="order",fetch=FetchType.LAZY)
    private List<OrderMenu> orderMenus;

}
