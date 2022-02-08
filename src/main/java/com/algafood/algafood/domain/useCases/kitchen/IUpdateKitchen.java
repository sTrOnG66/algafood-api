package com.algafood.algafood.domain.useCases.kitchen;

import com.algafood.algafood.domain.model.Kitchen;
import org.springframework.http.ResponseEntity;

public interface IUpdateKitchen {
    ResponseEntity<Kitchen> execute(Kitchen request, Long id);
}
