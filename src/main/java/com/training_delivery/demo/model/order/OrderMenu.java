package com.training_delivery.demo.model.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_order_menu SET order_menu_is_Deleted = true WHERE orders_menus_uuid = ?")
@SQLRestriction("where is_deleted = false")
@Table(name = "p_order_menu")
public class OrderMenu {
    @Id
    @Column(name = "orders_menus_uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String menuId;

    @Column(name = "order_menu_quantity")
    private int quantity;

    @Column(name = "order_menu_total_price")
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Builder.Default
    @Column(name = "order_menu_is_Deleted")
    private Boolean isDeleted = Boolean.FALSE;
}
