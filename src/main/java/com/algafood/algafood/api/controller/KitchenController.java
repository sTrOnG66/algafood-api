package com.algafood.algafood.api.controller;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.service.IKitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    IKitchenService kitchenService;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenService.listAll();
    }

    @PostMapping
    public Kitchen create(@RequestBody Kitchen request) {
        return kitchenService.create(request);
    }

    @GetMapping("/{id}")
    public Kitchen getById(@PathVariable Long id){
        return kitchenService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(
            @PathVariable Long id,
            @RequestBody Kitchen request) {
        return kitchenService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long id){
        return kitchenService.delete(id);
    }
}
