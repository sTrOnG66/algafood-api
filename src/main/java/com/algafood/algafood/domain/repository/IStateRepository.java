package com.algafood.algafood.domain.repository;

import com.algafood.algafood.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Long> {
}
