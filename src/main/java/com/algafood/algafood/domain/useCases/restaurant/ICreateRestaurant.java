package com.algafood.algafood.domain.useCases.restaurant;

import com.algafood.algafood.domain.dto.CreateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Restaurant;

public interface ICreateRestaurant {
    Restaurant execute(CreateRestaurantRequestDTO request);
}
