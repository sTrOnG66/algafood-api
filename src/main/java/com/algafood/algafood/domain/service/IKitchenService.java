package com.algafood.algafood.domain.service;

import com.algafood.algafood.domain.model.Kitchen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKitchenService {
    List<Kitchen> listAll();
    Kitchen create(Kitchen request);
    Kitchen getById(Long id);
    ResponseEntity<Kitchen> update(Kitchen request, Long id);
    ResponseEntity<Kitchen> delete(Long id);
}
