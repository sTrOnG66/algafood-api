package com.algafood.algafood.domain.useCases.restaurant.impl;

import com.algafood.algafood.domain.dto.CreateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.repository.IRestaurantRepository;
import com.algafood.algafood.domain.useCases.restaurant.ICreateRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreateRestaurantUseCase implements ICreateRestaurant {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    IKitchenRepository kitchenRepository;


    @Transactional
    @Override
    public Restaurant execute(CreateRestaurantRequestDTO request) {
        Optional<Restaurant> findRestaurantExists = restaurantRepository.findByName(request.getName());

        if (findRestaurantExists.isPresent()) {
            return null;
        }

        Optional<Kitchen> findKitchenExists = kitchenRepository.findById(request.getKitchenId());

        if (findKitchenExists.isEmpty()) {
            return null;
        }

        Restaurant newRestaurant = Restaurant.builder()
                .name(request.getName())
                .shippingFee(request.getShippingFee())
                .kitchen(findKitchenExists.get()).build();

        restaurantRepository.save(newRestaurant);

        return newRestaurant;
    }
}
