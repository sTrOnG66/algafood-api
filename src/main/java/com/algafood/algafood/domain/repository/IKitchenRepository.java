package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IKitchenRepository extends JpaRepository<Kitchen, Long> {
    Optional<Kitchen> findByName(String name);
}
