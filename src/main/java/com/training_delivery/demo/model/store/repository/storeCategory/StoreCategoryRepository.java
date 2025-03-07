package com.training_delivery.demo.model.store.repository.storeCategory;

import com.training_delivery.demo.model.store.entity.StoreCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoreCategoryRepository {

    List<StoreCategory> saveAll(List<StoreCategory> storeCategoryList);
}
