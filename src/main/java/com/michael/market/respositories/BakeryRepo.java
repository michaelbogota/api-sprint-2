package com.michael.market.respositories;

import com.michael.market.entities.BakeryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BakeryRepo extends JpaRepository<BakeryEntity, UUID> {

}
