package com.algafood.algafood.domain.useCases.kitchen.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.useCases.kitchen.IListKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListKitchenUseCase implements IListKitchen {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Override
    public List<Kitchen> execute() {
        return kitchenRepository.findAll();
    }
}
