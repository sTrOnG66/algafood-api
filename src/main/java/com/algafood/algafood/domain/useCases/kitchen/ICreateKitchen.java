package com.algafood.algafood.domain.useCases.kitchen;

import com.algafood.algafood.domain.model.Kitchen;

public interface ICreateKitchen {
    Kitchen execute(Kitchen request);
}
