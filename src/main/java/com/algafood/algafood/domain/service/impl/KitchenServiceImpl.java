package com.algafood.algafood.domain.service.impl;

import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.repository.IKitchenRepository;
import com.algafood.algafood.domain.service.IKitchenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KitchenServiceImpl implements IKitchenService {

    @Autowired
    IKitchenRepository kitchenRepository;

    @Override
    public List<Kitchen> listAll() {
        return kitchenRepository.findAll();
    }

    @Override
    @Transactional
    public Kitchen create(Kitchen request) {
        Optional<Kitchen> findKitchenExists = kitchenRepository.findByName(request.getName());

        return findKitchenExists.orElseGet(() -> kitchenRepository.save(request));
    }

    @Override
    public Kitchen getById(Long id) {
        Optional<Kitchen> kitchen = kitchenRepository.findById(id);

        return kitchen.orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<Kitchen> update(Kitchen request, Long id) {
        Optional<Kitchen> findKitchenExists = kitchenRepository.findById(id);

        if (findKitchenExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(request, findKitchenExists.get(), "id");

        kitchenRepository.save(findKitchenExists.get());

        return ResponseEntity.ok().body(findKitchenExists.get());
    }

    @Override
    @Transactional
    public ResponseEntity<Kitchen> delete(Long id) {
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
