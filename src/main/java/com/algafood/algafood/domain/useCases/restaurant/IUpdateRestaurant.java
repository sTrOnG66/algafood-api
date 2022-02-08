package com.algafood.algafood.domain.useCases.restaurant;

import com.algafood.algafood.domain.dto.UpdateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Restaurant;

public interface IUpdateRestaurant {
    Restaurant execute(UpdateRestaurantRequestDTO request, Long id);
}
