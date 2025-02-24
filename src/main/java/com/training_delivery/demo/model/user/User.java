package com.training_delivery.demo.model.user;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE p_user SET user_is_deleted = true WHERE user_id = ?")
@SQLRestriction("user_is_deleted = false")
@Table(name = "p_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_username", nullable = false, unique = true)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_first_name", nullable = false)
    private String firstName;

    @Column(name = "user_last_name", nullable = false)
    private String lastName;

    @Column(name = "user_nickname", nullable = false)
    private String nickname;

    @Column(name = "user_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_profile_image")
    private String profileImage;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "user_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @Column(name = "user_birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "user_token_issued_at")
    private LocalDateTime tokenIssuedAt;

    @Column(name = "user_is_deleted")
    @Builder.Default
    private Boolean isDeleted = Boolean.FALSE;
}
