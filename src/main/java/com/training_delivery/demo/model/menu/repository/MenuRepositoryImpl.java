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


    private final MenuJpaRepository menuJpaRepository;


    @Override
    public Menu findByMenuUuId(UUID menuUuId) {
        return menuJpaRepository.findByMenuUuId(menuUuId);
    }



    @Override
    public Page<Menu> findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(Store store, String search, Pageable pageable) {
        return menuJpaRepository.findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(store, search, pageable);
    }

    @Override
    public void save(Menu menu) {
        menuJpaRepository.save(menu);
    }
}
