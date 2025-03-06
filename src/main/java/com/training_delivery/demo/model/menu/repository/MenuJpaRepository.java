package com.training_delivery.demo.model.menu.repository;

import com.training_delivery.demo.model.menu.entity.Menu;
import com.training_delivery.demo.model.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuJpaRepository extends JpaRepository<Menu, Long> {

    Menu findByMenuUuId(UUID menuUuId);

    Page<Menu> findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(Store store, String search, Pageable pageable);
}
