package com.algafood.algafood.domain.useCases.restaurant.impl;

import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.IRestaurantRepository;
import com.algafood.algafood.domain.useCases.restaurant.IListRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ListRestaurantUseCase implements IListRestaurant {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> execute() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        if(restaurants.isEmpty()){
            return Collections.emptyList();
        }

        return restaurants;
    }
}
