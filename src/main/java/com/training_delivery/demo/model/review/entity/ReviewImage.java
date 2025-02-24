package com.training_delivery.demo.model.review.entity;

import com.training_delivery.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "p_review_image")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SQLDelete(sql = "UPDATE p_review_image SET review_image_is_Deleted = true WHERE review_image_id = ?")
@SQLRestriction("review_image_is_Deleted = false")
public class ReviewImage extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "review_image_id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;

	private String imageUrl;

	private String imageName;

	private Long imageSize;

	@Builder.Default
	@Column(name = "review_image_is_Deleted")
	private Boolean isDeleted = Boolean.FALSE;

}
