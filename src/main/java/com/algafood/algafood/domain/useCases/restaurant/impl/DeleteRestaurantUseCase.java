package com.algafood.algafood.domain.useCases.restaurant.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.repository.IRestaurantRepository;
import com.algafood.algafood.domain.useCases.restaurant.IDeleteRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DeleteRestaurantUseCase implements IDeleteRestaurant {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public ResponseEntity<Restaurant> execute(Long id) {
        try {
            Optional<Restaurant> findRestaurantExists = restaurantRepository.findById(id);

            if (findRestaurantExists.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            restaurantRepository.delete(findRestaurantExists.get());

            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
