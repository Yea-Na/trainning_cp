package com.training_delivery.demo.model.ai;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "p_ai")
public class Ai extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ai_id")
    private Long id;

    @Column(name ="ai_response_text", nullable = false, length = 150)
    private String responseText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
