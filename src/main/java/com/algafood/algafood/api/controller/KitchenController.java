package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.dto.UpdateRestaurantRequestDTO;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.useCases.kitchen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    ICreateKitchen create;

    @Autowired
    IListKitchen listKitchen;

    @Autowired
    IListKitchenById listKitchenById;

    @Autowired
    IUpdateKitchen updateKitchen;

    @Autowired
    IDeleteKitchen deleteKitchen;

    @GetMapping
    public List<Kitchen> list() {
        return listKitchen.execute();
    }

    @PostMapping
    public Kitchen create(@RequestBody Kitchen request) {
        return create.execute(request);
    }

    @GetMapping("/{id}")
    public Kitchen getById(@PathVariable Long id){
        return listKitchenById.execute(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(
            @PathVariable Long id,
            @RequestBody Kitchen request) {
        return updateKitchen.execute(request, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long id){
        return deleteKitchen.execute(id);
    }
}
