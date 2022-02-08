package com.algafood.algafood.domain.useCases.restaurant;

import com.algafood.algafood.domain.model.Restaurant;
import org.springframework.http.ResponseEntity;

public interface IDeleteRestaurant {
    ResponseEntity<Restaurant> execute(Long id);
}
