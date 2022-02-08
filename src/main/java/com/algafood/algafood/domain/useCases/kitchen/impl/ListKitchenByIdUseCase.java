package com.algafood.algafood.domain.useCases.kitchen.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.useCases.kitchen.IListKitchenById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListKitchenByIdUseCase implements IListKitchenById {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Override
    public Kitchen execute(Long id) {
        Optional<Kitchen> kitchen = kitchenRepository.findById(id);

        return kitchen.orElse(null);
    }
}
