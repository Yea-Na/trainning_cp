package com.training_delivery.demo.model.store.repository.location;

import com.training_delivery.demo.model.store.entity.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final LocationJpaRepository locationJpaRepository;

    @Override
    public Location save(Location saveLocation) {
        return locationJpaRepository.save(saveLocation);
    }
}
