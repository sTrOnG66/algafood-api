package com.algafood.algafood.domain.useCases.kitchen;

import com.algafood.algafood.domain.model.Kitchen;

public interface IListKitchenById {
    Kitchen execute(Long id);
}
