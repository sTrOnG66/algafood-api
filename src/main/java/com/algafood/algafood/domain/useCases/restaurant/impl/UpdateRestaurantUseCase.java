package com.algafood.algafood.domain.useCases.restaurant.impl;

import com.algafood.algafood.domain.dto.UpdateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.repository.IRestaurantRepository;
import com.algafood.algafood.domain.useCases.restaurant.IUpdateRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateRestaurantUseCase implements IUpdateRestaurant {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    IKitchenRepository kitchenRepository;

    @Transactional
    @Override
    public Restaurant execute(UpdateRestaurantRequestDTO request, Long id) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findById(id);

        if(findRestaurant.isEmpty()){
            return null;
        }

        findRestaurant.get().setName(request.getName() != null ? request.getName() : findRestaurant.get().getName());
        findRestaurant.get().setShippingFee(request.getShippingFee() != null ? request.getShippingFee() : findRestaurant.get().getShippingFee());

        if(request.getKitchenId() != null) {
            Optional<Kitchen> findKitchen = kitchenRepository.findById(request.getKitchenId());
            findKitchen.ifPresent(kitchen -> findRestaurant.get().setKitchen(kitchen));
        }

        return restaurantRepository.save(findRestaurant.get());
    }
}
