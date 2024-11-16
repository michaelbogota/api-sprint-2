package com.michael.market.respositories;

import com.michael.market.entities.FruitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FruitsRepo  extends JpaRepository<FruitsEntity, UUID> {

}
