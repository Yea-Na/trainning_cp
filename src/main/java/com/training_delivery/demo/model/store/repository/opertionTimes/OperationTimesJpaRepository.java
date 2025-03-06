package com.training_delivery.demo.model.store.repository.opertionTimes;

import com.training_delivery.demo.model.store.entity.OperationTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTimesJpaRepository extends JpaRepository<OperationTimes, Long> {
}
