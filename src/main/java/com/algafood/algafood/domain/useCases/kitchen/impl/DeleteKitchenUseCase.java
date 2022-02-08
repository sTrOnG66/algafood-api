package com.algafood.algafood.domain.useCases.kitchen.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.useCases.kitchen.IDeleteKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DeleteKitchenUseCase implements IDeleteKitchen {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Transactional
    @Override
    public ResponseEntity<Kitchen> execute(Long id) {
        try {
            Optional<Kitchen> findKitchenExists = kitchenRepository.findById(id);

            if (findKitchenExists.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            kitchenRepository.delete(findKitchenExists.get());

            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
