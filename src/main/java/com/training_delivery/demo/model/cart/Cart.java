package com.training_delivery.demo.model.cart;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import com.server.delivery.model.cart.entity.MenuCart;


import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_cart SET cart_is_deleted = true WHERE cart_uuid = ?")
@SQLRestriction("where cart_is_deleted = false")
@Table(name = "p_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_uuid")
    private UUID cartUuid;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "total_price")
    private int totalPrice;

    @OneToMany(mappedBy="cart",fetch=FetchType.LAZY)
    private List<MenuCart> menuCarts;

}
