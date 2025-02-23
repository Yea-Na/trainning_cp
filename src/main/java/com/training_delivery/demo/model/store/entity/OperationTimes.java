package com.training_delivery.demo.model.store.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SQLRestriction("operation_times_is_deleted = false")
@Table(name = "p_operation_times")
public class OperationTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "store_operating_times_uuid")
    private UUID storeOperatingTimesUuid;

    @Column(name = "weekday", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private WeekDays weekday;

    @Column(name = "operation_times_opening_time", nullable = false)
    private String operationTimeOpeningTime;

    @Column(name = "operation_times_closing_time", nullable = false)
    private String operationTimeClosingTime;

    @Column(name = "operation_times_is_holiday", nullable = false)
    private boolean isHoliday;

    @Builder.Default
    @Column(name = "operation_times_is_deleted")
    private boolean isDeleted = Boolean.FALSE;

}
