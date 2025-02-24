package com.training_delivery.demo.model.review.entity;


import com.training_delivery.demo.common.BaseEntity;
import com.training_delivery.demo.model.order.entity.Order;
import com.training_delivery.demo.model.store.entity.Store;
import com.training_delivery.demo.model.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "p_review")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SQLDelete(sql = "UPDATE p_review SET review_is_deleted = true WHERE review_id = ?")
@SQLRestriction("review_is_deleted = false")
public class Review extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "review_id")
	private UUID id;

	private String content;

	private Double rating;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Builder.Default
	@OneToMany(mappedBy = "review")
	private List<ReviewImage> images = new ArrayList<>();

	@Builder.Default
	@Column(name = "review_is_deleted")
	private Boolean isDeleted = Boolean.FALSE;

	@ManyToOne
	@JoinColumn(name = "store_uuid")
	private Store store;

	@OneToOne
	@JoinColumn(name = "order_uuid", unique = true)
	private Order order;


}
