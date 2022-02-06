package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.model.Restaurant;
import org.springframework.http.ResponseEntity;

public interface IRestaurantService {
    ResponseEntity<Restaurant> create(Restaurant request);
}
