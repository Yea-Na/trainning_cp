package com.training_delivery.demo.model.store.repository.location;

import com.training_delivery.demo.model.store.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {
}
