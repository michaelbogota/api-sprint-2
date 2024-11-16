package com.michael.market.respositories;

import com.michael.market.entities.VegetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VegetableRepo extends JpaRepository<VegetableEntity, UUID> {

}
