package com.training_delivery.demo.model.menu.repository;

import com.training_delivery.demo.model.menu.entity.Menu;
import com.training_delivery.demo.model.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MenuRepository  {



    Menu findByUuid(UUID menuUuId);


    Optional<Menu> findById(UUID menuUuid);

    Page<Menu> findByStoreAndMenuNameContainingAndMenuAvailabilityTrue(Store store, String search, Pageable pageable);

    void save(Menu menu);
}
