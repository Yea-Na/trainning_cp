package com.training_delivery.demo.model.master.repository;

import com.training_delivery.demo.model.master.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MasterJpaRepository extends JpaRepository<Master, Long> {


}
