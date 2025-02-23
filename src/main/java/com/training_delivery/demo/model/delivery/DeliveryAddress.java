package com.training_delivery.demo.model.delivery;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_delivery SET delivery_address_is_deleted = true WHERE delivery_address_id = ?")
@SQLRestriction("delivery_address_is_deleted = false")
@Table(name = "p_delivery_address")
public class DeliveryAddress extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "delivery_address_id")
	private UUID id;

	@Column(name = "delivery_zipcode")
	private String zipcode;

	@Column(name = "delivery_city")
	private String city;

	@Column(name = "delivery_detail_address")
	private String detailAddress;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Builder.Default
	@Column(name = "delivery_address_is_deleted")
	private Boolean isDeleted = Boolean.FALSE;
}
