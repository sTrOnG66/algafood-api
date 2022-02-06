package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    //TODO -> Criar, listar, listar por id, deletar

    @Autowired
    IRestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant request) {
        return restaurantService.create(request);
    }

    //@GetMapping()
}
