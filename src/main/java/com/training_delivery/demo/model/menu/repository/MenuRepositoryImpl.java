package com.training_delivery.demo.model.menu.repository;

import com.training_delivery.demo.model.menu.entity.Menu;
import com.training_delivery.demo.model.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {

    private final MenuRepository menuRepository;


    @Override
    public Menu findByUuid(UUID menuUuId) {
        return menuRepository.findByUuid(menuUuId);
    }

    @Override
    public Optional<Menu> findById(UUID menuUuid) {
        return Optional.empty();
    }

    @Override
    public Page<Menu> findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(Store store, String search, Pageable pageable) {
        return menuRepository.findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(store, search, pageable);
    }

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }
}
