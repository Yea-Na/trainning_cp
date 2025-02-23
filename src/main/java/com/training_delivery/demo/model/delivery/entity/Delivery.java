package com.training_delivery.demo.model.delivery.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_delivery SET delivery_is_deleted = true WHERE delivery_id = ?")
@SQLRestriction("delivery_is_deleted = false")
@Table(name = "p_delivery")
public class Delivery extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "delivery_id")
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "delivery_status")
	private DeliveryStatus status;

	@Column(name = "delivery_start_time")
	private LocalDateTime deliveryStartTime;

	@Column(name = "delivery_arrival_time") // 도착 예상 시간
	private Integer deliveryArrivalTime;

	@Column(name = "delivery_cancel_reason")
	private String cancelReason;

	@OneToOne(mappedBy = "delivery")
	private Order order;


	@Column(name = "delivery_tip")
	@Builder.Default
	private int deliveryTip = 3000;

	@Builder.Default
	@Column(name = "delivery_is_deleted")
	private Boolean isDeleted = Boolean.FALSE;



}
