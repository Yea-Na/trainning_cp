package com.training_delivery.demo.model.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "p_user_store")
public class UserStore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_store_uuid")
    private String uuid;
}
