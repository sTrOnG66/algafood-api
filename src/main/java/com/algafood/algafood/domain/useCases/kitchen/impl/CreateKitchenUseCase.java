package com.algafood.algafood.domain.useCases.kitchen.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.useCases.kitchen.ICreateKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreateKitchenUseCase implements ICreateKitchen {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Transactional
    @Override
    public Kitchen execute(Kitchen request) {
        Optional<Kitchen> findKitchenExists = kitchenRepository.findByName(request.getName());

        return findKitchenExists.orElseGet(() -> kitchenRepository.save(request));
    }
}
