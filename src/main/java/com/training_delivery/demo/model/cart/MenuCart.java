package com.server.delivery.model.cart.entity;

import com.training_delivery.demo.model.cart.Cart;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "p_menu_cart")
public class MenuCart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "menu_cart_uuid")
    private UUID menuCartUuid;

    @Column(name = "menu_cart_quantity", nullable = false)
    private int quantity;

    @Column(name = "menu_cart_total_price", nullable = false)
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
}
