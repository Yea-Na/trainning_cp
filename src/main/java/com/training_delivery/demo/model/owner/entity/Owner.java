package com.training_delivery.demo.model.owner.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_owner SET owner_is_Deleted = true WHERE owner_uuid = ?")
@SQLRestriction("owner_is_deleted = false")
@Table(name = "p_owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    //owner 사업자번호??


}
