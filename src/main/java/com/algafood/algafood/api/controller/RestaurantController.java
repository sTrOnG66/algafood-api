package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.dto.CreateRestaurantRequestDTO;
import com.algafood.algafood.domain.dto.UpdateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Restaurant;
import com.algafood.algafood.domain.useCases.restaurant.ICreateRestaurant;
import com.algafood.algafood.domain.useCases.restaurant.IDeleteRestaurant;
import com.algafood.algafood.domain.useCases.restaurant.IListRestaurant;
import com.algafood.algafood.domain.useCases.restaurant.IUpdateRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    //TODO -> Criar, listar, listar por id, deletar

    @Autowired
    ICreateRestaurant createRestaurant;

    @Autowired
    IUpdateRestaurant updateRestaurant;

    @Autowired
    IListRestaurant listRestaurant;

    @Autowired
    IDeleteRestaurant deleteRestaurant;

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody @Validated CreateRestaurantRequestDTO request) {
        Restaurant restaurant = createRestaurant.execute(request);

        if(restaurant == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> list(){
        List<Restaurant> restaurant = listRestaurant.execute();

        if(restaurant.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@RequestBody UpdateRestaurantRequestDTO request, @PathVariable Long id){
        Restaurant restaurant =  updateRestaurant.execute(request, id);

        if(restaurant == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurant> delete(@PathVariable Long id){
        return deleteRestaurant.execute(id);
    }
}
