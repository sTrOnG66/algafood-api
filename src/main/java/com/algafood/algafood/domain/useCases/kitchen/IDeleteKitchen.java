package com.algafood.algafood.domain.useCases.kitchen;

import com.algafood.algafood.domain.model.Kitchen;
import org.springframework.http.ResponseEntity;

public interface IDeleteKitchen {
    ResponseEntity<Kitchen> execute(Long id);
}
