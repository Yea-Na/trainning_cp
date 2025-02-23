package com.training_delivery.demo.model.menu.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SQLDelete(sql = "UPDATE p_menus SET menu_availability = FALSE WHERE menu_uuid = ?")
@SQLRestriction("menu_availability = true")
@Table(name = "p_menus")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "menu_uuid")
    private UUID menuUuId;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "menu_description")
    private String menuDescription;

    @Column(name = "menu_price", nullable = false)
    private int menuPrice;

    @Column(name = "menu_availability", nullable = false)
    private boolean menuAvailability;

    @Column(name = "food_image")
    private String foodImage;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;


    @OneToMany(mappedBy = "menu")
    private List<MenuCart> menuCarts;

}
