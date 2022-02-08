package com.algafood.algafood.domain.useCases.kitchen.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.useCases.kitchen.IUpdateKitchen;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateKitchenUseCase implements IUpdateKitchen {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Transactional
    @Override
    public ResponseEntity<Kitchen> execute(Kitchen request, Long id) {
        Optional<Kitchen> findKitchenExists = kitchenRepository.findById(id);

        if (findKitchenExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request, findKitchenExists.get(), "id");

        kitchenRepository.save(findKitchenExists.get());

        return ResponseEntity.ok().body(findKitchenExists.get());
    }
}
