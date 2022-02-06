package com.algafood.algafood.domain.service.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.repository.IRestaurantRepository;
import com.algafood.algafood.domain.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Autowired
    IKitchenRepository kitchenRepository;

    @Override
    @Transactional
    public ResponseEntity<Restaurant> create(Restaurant request) {
        Optional<Restaurant> findRestaurantExists = restaurantRepository.findByName(request.getName());

        if(findRestaurantExists.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Optional<Kitchen> findKitchenExists = kitchenRepository.findById(request.getKitchen().getId());

        if(findKitchenExists.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        request.setKitchen(findKitchenExists.get());

        restaurantRepository.save(request);

        return ResponseEntity.ok(request);
    }
}
